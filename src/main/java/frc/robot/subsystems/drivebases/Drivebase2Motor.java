package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;

public class Drivebase2Motor extends Drivebase
{
    TalonSRX leftMotor = new TalonSRX(Constants.MotorPorts.TwoMotors.LEFT_MOTOR_1_DEVICE_NUMBER);
    TalonSRX rightMotor = new TalonSRX(Constants.MotorPorts.TwoMotors.RIGHT_MOTOR_1_DEVICE_NUMBER);

    private final double distancePerMotorRotation = 0.006135923151543;

    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor.set(TalonSRXControlMode.PercentOutput, -turnSpeedLeft);
        rightMotor.set(TalonSRXControlMode.PercentOutput, turnSpeedRight);
    }

    public double getPosLeft()
    {
        return leftMotor.getSelectedSensorPosition();
    }

    public double getPosRight()
    {
        return rightMotor.getSelectedSensorPosition();
    }

    public Drivebase2Motor()
    {
        leftMotor.setSelectedSensorPosition(distancePerMotorRotation);
        rightMotor.setSelectedSensorPosition(distancePerMotorRotation);
    }

    public double getHeading()
    {
        return 0;
    }

    public double getTicksLeft(){return 0;}

    public boolean isCalibrating()
    {
        return false;
    }

    public void turnOffBrakes()
    {

    }

    public double getSpeedLeft()
    {
        return leftMotor.getSelectedSensorVelocity();
    }

    public double getSpeedRight()
    {
        return (-rightMotor.getSelectedSensorVelocity());
    }
}
