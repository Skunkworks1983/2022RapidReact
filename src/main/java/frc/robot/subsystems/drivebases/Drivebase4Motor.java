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

    @Override

    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        leftMotor2.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        rightMotor1.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
        rightMotor2.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
    }
}
