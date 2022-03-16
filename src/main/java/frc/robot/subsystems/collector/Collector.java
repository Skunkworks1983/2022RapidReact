package frc.robot.subsystems.collector;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public class Collector extends SubsystemBase
{
    TalonFX collectorMotor1 = new TalonFX(Constants.MotorPorts.Collector.COLLECTOR_MOTOR_DEVICE_NUMBER1);
    TalonFX collectorMotor2 = new TalonFX(Constants.MotorPorts.Collector.COLLECTOR_MOTOR_DEVICE_NUMBER2);
    TalonFX intakeMotor = new TalonFX(Constants.MotorPorts.Collector.COLLECTOR_INTAKE_MOTOR_DEVICE_NUMBER);

    public double encoderToAngleFactor = ((1/Constants.Falcon500.TICKS_PER_REV)/Constants.Collector.GEAR_RATIO)*360;

    public Collector()
    {
        collectorMotor2.setInverted(true);
        collectorMotor2.follow(collectorMotor1);
    }


    public void collectBalls(double speed)
    {
        intakeMotor.set(TalonFXControlMode.PercentOutput, speed);
    }

    public void setCollectorAngleSpeed(double speed)
    {
        collectorMotor1.set(TalonFXControlMode.PercentOutput, speed);

    }

    public double getCollectorAngle()
    {
        return collectorMotor1.getSelectedSensorPosition() * encoderToAngleFactor;
    }

    public void collectorEncoderReset()
    {
        collectorMotor1.setSelectedSensorPosition(0);
    }
}
