package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;

public class ExitTarmac extends SequentialCommandGroup
{
    public ExitTarmac(Drivebase drivebase)
    {
        addCommands(new DriveDistanceCommand(drivebase, Constants.EXIT_TARMAC_DRIVE_DISTANCE));
    }
}
