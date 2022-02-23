package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.subsystems.Drivebase;

import java.lang.reflect.Method;

public class ExitTarmac extends SequentialCommandGroup
{
    public ExitTarmac(Drivebase drivebase)
    {
        addCommands(new DriveDistanceCommand(drivebase, 10));
    }
}
