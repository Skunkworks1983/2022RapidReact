package frc.robot.commands.auto;

import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;

public class TwoBallAutoCenter extends SequentialCommandGroup
{
    public TwoBallAutoCenter(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands
        (
            new DriveDistanceCommand(drivebase, 2)
        );
    }
}
