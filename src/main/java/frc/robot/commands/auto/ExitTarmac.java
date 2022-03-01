package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebaseCommands.DriveDistanceCommand;
import frc.robot.subsystems.Drivebase;

public class ExitTarmac extends SequentialCommandGroup
{
    public ExitTarmac(Drivebase drivebase)
    {
        addCommands(new DriveDistanceCommand(drivebase, 10));
    }
}
