package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public abstract class Collector extends SubsystemBase
{
    TalonFX intakeMotor = new TalonFX(Constants.MotorPorts.Collector.COLLECTOR_INTAKE_MOTOR_DEVICE_NUMBER);

    public void collectBalls(double speed)
    {
        intakeMotor.set(TalonFXControlMode.PercentOutput, speed);
    }

    TalonFX collectorMotor = new TalonFX(Constants.MotorPorts.Collector.COLLECTOR_MOTOR_DEVICE_NUMBER);

    public double encoderToAngleFactor = 1;

    public void setCollectorAngleSpeed(double speed)
    {
        collectorMotor.set(TalonFXControlMode.PercentOutput, speed);
    }

    public double getCollectorAngle()
    {
        return collectorMotor.getSelectedSensorPosition() * encoderToAngleFactor;
    }
}
