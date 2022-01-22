package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;

public class Drivebase2Motor extends Drivebase
{
    TalonSRX leftMotor = new TalonSRX(Constants.MotorPorts.twoMotors.leftMotor1DeviceNumber);
    TalonSRX rightMotor = new TalonSRX(Constants.MotorPorts.twoMotors.rightMotor1DeviceNumber);

    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        rightMotor.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
    }
}
