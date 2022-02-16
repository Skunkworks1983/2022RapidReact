package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivebase;

public class AutoCommands extends SequentialCommandGroup
{
    public AutoCommands(Drivebase drivebase)
    {
        addCommands
        (
            new DriveDistanceCommand(drivebase, -10, .5)
        );
    }
}
