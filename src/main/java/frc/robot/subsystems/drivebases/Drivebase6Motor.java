package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;

public class Drivebase6Motor extends Drivebase
{
    CANSparkMax leftMotor1 = new CANSparkMax(Constants.MotorPorts.sixMotors.leftMotor1DeviceNumber, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax leftMotor2 = new CANSparkMax(Constants.MotorPorts.sixMotors.leftMotor2DeviceNumber, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax leftMotor3 = new CANSparkMax(Constants.MotorPorts.sixMotors.leftMotor3DeviceNumber, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax rightMotor1 = new CANSparkMax(Constants.MotorPorts.sixMotors.rightMotor1DeviceNumber, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax rightMotor2 = new CANSparkMax(Constants.MotorPorts.sixMotors.rightMotor2DeviceNumber, CANSparkMaxLowLevel.MotorType.kBrushless);
    CANSparkMax rightMotor3 = new CANSparkMax(Constants.MotorPorts.sixMotors.rightMotor3DeviceNumber, CANSparkMaxLowLevel.MotorType.kBrushless);

    private final double distancePerMotorRotation = 0.2067;

    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(-turnSpeedLeft);
        leftMotor2.set(-turnSpeedLeft);
        leftMotor3.set(-turnSpeedLeft);
        rightMotor1.set(turnSpeedRight);
        rightMotor2.set(turnSpeedRight);
        rightMotor3.set(turnSpeedRight);
    }

    public double getPosLeft()
    {
        return (leftMotor1.getEncoder().getPosition() + leftMotor2.getEncoder().getPosition() + leftMotor3.getEncoder().getPosition())/3;
    }

    public double getPosRight()
    {
        return (rightMotor1.getEncoder().getPosition() + rightMotor2.getEncoder().getPosition() + rightMotor3.getEncoder().getPosition())/3;
    }

    public Drivebase6Motor()
    {
        leftMotor1.getEncoder().setPositionConversionFactor(distancePerMotorRotation);
        leftMotor2.getEncoder().setPositionConversionFactor(distancePerMotorRotation);
        leftMotor3.getEncoder().setPositionConversionFactor(distancePerMotorRotation);
        rightMotor1.getEncoder().setPositionConversionFactor(distancePerMotorRotation);
        rightMotor2.getEncoder().setPositionConversionFactor(distancePerMotorRotation);
        rightMotor3.getEncoder().setPositionConversionFactor(distancePerMotorRotation);
    }
}