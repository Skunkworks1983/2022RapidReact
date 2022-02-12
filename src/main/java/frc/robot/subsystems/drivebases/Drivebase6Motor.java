package frc.robot.subsystems.drivebases;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;

public class Drivebase6Motor extends Drivebase
{
    CANSparkMax leftMotor1 = new CANSparkMax(Constants.MotorPorts.SixMotors.LEFT_MOTOR_1_DEVICE_NUMBER, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax leftMotor2 = new CANSparkMax(Constants.MotorPorts.SixMotors.LEFT_MOTOR_2_DEVICE_NUMBER, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax leftMotor3 = new CANSparkMax(Constants.MotorPorts.SixMotors.LEFT_MOTOR_3_DEVICE_NUMBER, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax rightMotor1 = new CANSparkMax(Constants.MotorPorts.SixMotors.RIGHT_MOTOR_1_DEVICE_NUMBER, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax rightMotor2 = new CANSparkMax(Constants.MotorPorts.SixMotors.RIGHT_MOTOR_2_DEVICE_NUMBER, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax rightMotor3 = new CANSparkMax(Constants.MotorPorts.SixMotors.RIGHT_MOTOR_3_DEVICE_NUMBER, CANSparkMaxLowLevel.MotorType.kBrushless);

    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(-turnSpeedLeft);
        leftMotor2.set(-turnSpeedLeft);
        leftMotor3.set(-turnSpeedLeft);
        rightMotor1.set(turnSpeedRight);
        rightMotor2.set(turnSpeedRight);
        rightMotor3.set(turnSpeedRight);
    }
}
