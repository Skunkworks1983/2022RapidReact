package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.RotateCommand;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;

public class AutoCodeB extends SequentialCommandGroup
{
    public AutoCodeB(Drivebase drivebase, Collector collector)
    {
        addCommands
                (
                        new DriveDistanceCommand(drivebase, 2.92),
                        new GrabBall(collector),
                        new DriveDistanceCommand(drivebase, -2.92),
                        new RotateCommand(drivebase, 90)
                        );
    }
}
