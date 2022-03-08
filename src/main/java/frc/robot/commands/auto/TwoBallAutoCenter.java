package frc.robot.commands.auto;

import frc.robot.commands.drivebase.RotateCommand;
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
            new DriveDistanceCommand(drivebase, 2),
            new RotateCommand(drivebase, -10),
            new DriveAndCollectCommandGroup(drivebase, collector, 3.0, shooter),
            //new DriveDistanceCommand(drivebase, 3), // change to drive and collect
            new RotateCommand(drivebase, -150),
            new DriveDistanceCommand(drivebase, 8),
            new RotateCommand(drivebase, -65),
            new TimedDriveForwardCommandGroup(3.0, 0.2, drivebase),
            new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
        );
    }
}
