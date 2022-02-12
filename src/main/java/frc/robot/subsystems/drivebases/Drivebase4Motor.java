package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;


public class Drivebase4Motor extends Drivebase
{
    TalonSRX leftMotor1 = new TalonSRX(Constants.MotorPorts.fourMotors.leftMotor1DeviceNumber);
    TalonSRX leftMotor2 = new TalonSRX(Constants.MotorPorts.fourMotors.leftMotor2DeviceNumber);
    TalonSRX rightMotor1 = new TalonSRX(Constants.MotorPorts.fourMotors.rightMotor1DeviceNumber);
    TalonSRX rightMotor2 = new TalonSRX(Constants.MotorPorts.fourMotors.rightMotor2DeviceNumber);

    Encoder leftEncoder = new Encoder(Constants.encoderPorts.fourMotorTalonSRX.leftAPort, Constants.encoderPorts.fourMotorTalonSRX.leftBPort);
    Encoder rightEncoder = new Encoder(Constants.encoderPorts.fourMotorTalonSRX.rightAPort, Constants.encoderPorts.fourMotorTalonSRX.rightBPort);

    AHRS gyro = new AHRS(I2C.Port.kOnboard);

    private final double distancePerMotorRotation = 0.006135923151543;

    @Override
    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(TalonSRXControlMode.PercentOutput, turnSpeedLeft);
        leftMotor2.set(TalonSRXControlMode.PercentOutput, turnSpeedLeft);
        rightMotor1.set(TalonSRXControlMode.PercentOutput, -turnSpeedRight);
        rightMotor2.set(TalonSRXControlMode.PercentOutput, -turnSpeedRight);
        //System.out.println("going at: "+turnSpeedLeft+" Left, going at: "+turnSpeedRight+" right, degree: "+getHeading());
    }

    public double getPosLeft()
    {
        return (leftEncoder.getDistance());
    }

    public double getPosRight()
    {
        return (-rightEncoder.getDistance());
    }

    public double getHeading()
    {
        return gyro.getAngle();
    }

    public boolean isCalibrating()
    {
        return gyro.isCalibrating();
    }

    public Drivebase4Motor()
    {
        /* leftMotor1.configSelectedFeedbackCoefficient(distancePerMotorRotation);
        leftMotor2.configSelectedFeedbackCoefficient(distancePerMotorRotation);
        rightMotor1.configSelectedFeedbackCoefficient(distancePerMotorRotation);
        rightMotor2.configSelectedFeedbackCoefficient(distancePerMotorRotation); */
        leftEncoder.setDistancePerPulse(distancePerMotorRotation);
        rightEncoder.setDistancePerPulse(distancePerMotorRotation);
    }
}