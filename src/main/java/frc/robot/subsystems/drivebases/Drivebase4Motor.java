package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;


public class Drivebase4Motor extends Drivebase
{
    TalonSRX leftMotor1 = new TalonSRX(Constants.MotorPorts.FourMotors.LEFT_MOTOR_1_DEVICE_NUMBER);
    TalonSRX leftMotor2 = new TalonSRX(Constants.MotorPorts.FourMotors.LEFT_MOTOR_2_DEVICE_NUMBER);
    TalonSRX rightMotor1 = new TalonSRX(Constants.MotorPorts.FourMotors.RIGHT_MOTOR_1_DEVICE_NUMBER);
    TalonSRX rightMotor2 = new TalonSRX(Constants.MotorPorts.FourMotors.RIGHT_MOTOR_2_DEVICE_NUMBER);

    @Override

    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        leftMotor2.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        rightMotor1.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
        rightMotor2.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
    }
}
