package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;


public class Drivebase4MotorFalcon500 extends Drivebase
{
    TalonFX leftMotor1 = new TalonFX(Constants.MotorPorts.FourMotorFalcon500.LEFT_MOTOR_1_DEVICE_NUMBER);
    TalonFX leftMotor2 = new TalonFX(Constants.MotorPorts.FourMotorFalcon500.LEFT_MOTOR_2_DEVICE_NUMBER);
    TalonFX rightMotor1 = new TalonFX(Constants.MotorPorts.FourMotorFalcon500.RIGHT_MOTOR_1_DEVICE_NUMBER);
    TalonFX rightMotor2 = new TalonFX(Constants.MotorPorts.FourMotorFalcon500.RIGHT_MOTOR_2_DEVICE_NUMBER);

    private final double TicksPerRev = 2048;
    private final double GearRatio = 10.71;
    private final double WheelDiameter = 0.5;
    private final double TicksPerFoot = TicksPerRev * GearRatio / (WheelDiameter * Math.PI);

    AHRS gyro = new AHRS(I2C.Port.kOnboard);

    public void Drivebase4MotorPhoenix500()
    {
        leftMotor1.configOpenloopRamp(0.4, 30);
        leftMotor2.configOpenloopRamp(0.4, 30);
        rightMotor1.configOpenloopRamp(0.4, 30);
        rightMotor2.configOpenloopRamp(0.4, 30);
    }

    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(TalonFXControlMode.PercentOutput, turnSpeedLeft);
        leftMotor2.set(TalonFXControlMode.PercentOutput, turnSpeedLeft);
        rightMotor1.set(TalonFXControlMode.PercentOutput, -turnSpeedRight);
        rightMotor2.set(TalonFXControlMode.PercentOutput, -turnSpeedRight);
    }


    public double getPosLeft()
    {
        return leftMotor1.getSelectedSensorPosition()/TicksPerFoot;
    }

    public double getPosRight()
    {
        return -(rightMotor1.getSelectedSensorPosition()/TicksPerFoot);
    }

    public double getHeading()
    {
        return gyro.getAngle();
    }

    public boolean isCalibrating()
    {
        return gyro.isCalibrating();
    }

    public double getTicksLeft(){return leftMotor1.getSelectedSensorPosition();}

    public void turnOffBrakes()
    {

    }
}
