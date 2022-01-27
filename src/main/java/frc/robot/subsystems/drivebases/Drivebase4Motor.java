package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;


public class Drivebase4Motor extends Drivebase
{
    TalonSRX leftMotor1 = new TalonSRX(Constants.MotorPorts.fourMotors.leftMotor1DeviceNumber);
    TalonSRX leftMotor2 = new TalonSRX(Constants.MotorPorts.fourMotors.leftMotor2DeviceNumber);
    TalonSRX rightMotor1 = new TalonSRX(Constants.MotorPorts.fourMotors.rightMotor1DeviceNumber);
    TalonSRX rightMotor2 = new TalonSRX(Constants.MotorPorts.fourMotors.rightMotor2DeviceNumber);

    private final double distancePerMotorRotation = 0.006135923151543;

    @Override
    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        leftMotor2.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        rightMotor1.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
        rightMotor2.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);

        //leftMotor2.configSelectedFeedbackCoefficient()

        System.out.println(Math.PI);
    }

    public double getPosLeft()
    {
        return (leftMotor1.getSelectedSensorPosition() + leftMotor2.getSelectedSensorPosition())/2;
    }

    public double getPosRight()
    {
        return (rightMotor1.getSelectedSensorPosition() + rightMotor2.getSelectedSensorPosition())/2;
    }

    public Drivebase4Motor()
    {
        leftMotor1.configSelectedFeedbackCoefficient(distancePerMotorRotation);
        leftMotor2.configSelectedFeedbackCoefficient(distancePerMotorRotation);
        rightMotor1.configSelectedFeedbackCoefficient(distancePerMotorRotation);
        rightMotor2.configSelectedFeedbackCoefficient(distancePerMotorRotation);
    }
}
