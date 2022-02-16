package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public abstract class Collector extends SubsystemBase
{
    TalonFX intakeMotor = new TalonFX(Constants.MotorPorts.Collector.COLLECTOR_MOTOR_DEVICE_NUMBER);
    public void collectBalls(double speed)
    {
        intakeMotor.set(TalonFXControlMode.PercentOutput, speed);
    }

    public abstract void setCollectorAngled(boolean moveDownward);
}
