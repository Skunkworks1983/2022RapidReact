package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public class Collector extends SubsystemBase
{
    CANSparkMax intakeMotor = new CANSparkMax(Constants.MotorPorts.collector.collectorMotorDeviceNumber);
    public void collectBalls(double speed)
    {

    }
}
