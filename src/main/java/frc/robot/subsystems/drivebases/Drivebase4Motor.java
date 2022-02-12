package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;


public class Drivebase4Motor extends Drivebase
{
    TalonSRX leftMotor1 = new TalonSRX(Constants.MotorPorts.FourMotors.LEFT_MOTOR_1_DEVICE_NUMBER);
    TalonSRX leftMotor2 = new TalonSRX(Constants.MotorPorts.FourMotors.LEFT_MOTOR_2_DEVICE_NUMBER);
    TalonSRX rightMotor1 = new TalonSRX(Constants.MotorPorts.FourMotors.RIGHT_MOTOR_1_DEVICE_NUMBER);
    TalonSRX rightMotor2 = new TalonSRX(Constants.MotorPorts.FourMotors.RIGHT_MOTOR_2_DEVICE_NUMBER);

    Encoder leftEncoder = new Encoder(Constants.encoderPorts.FourMotorTalonSRX.LEFT_A_PORT, Constants.encoderPorts.FourMotorTalonSRX.LEFT_B_PORT);
    Encoder rightEncoder = new Encoder(Constants.encoderPorts.FourMotorTalonSRX.RIGHT_A_PORT, Constants.encoderPorts.FourMotorTalonSRX.RIGHT_B_PORT);

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