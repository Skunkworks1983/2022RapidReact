package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Encoder;
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

    private final double distancePerMotorRotation = 0.006135923151543;

    @Override
    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        leftMotor2.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        rightMotor1.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
        rightMotor2.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
    }

    public double getPosLeft()
    {
        return (leftEncoder.getDistance());
        //return (double)leftEncoder.getRaw();
    }

    public double getPosRight()
    {
        return (-rightEncoder.getDistance());
        //return (double)rightEncoder.get();
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
