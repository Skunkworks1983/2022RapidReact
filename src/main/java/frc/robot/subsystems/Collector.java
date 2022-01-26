package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public class Collector extends SubsystemBase
{
    CANSparkMax intakeMotor = new CANSparkMax(Constants.MotorPorts.collector.collectorMotorDeviceNumber, CANSparkMaxLowLevel.MotorType.kBrushless);
    public void collectBalls(double speed)
    {
        intakeMotor.set(speed);
    }
}
