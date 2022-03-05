package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.commands.drivebase.RotateCommand;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class TwoBallAutoLeft extends SequentialCommandGroup
{
    public TwoBallAutoLeft(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands(new DriveAndCollectCommandGroup(drivebase, collector,3.5, shooter),
                    new DriveDistanceCommand(drivebase, -6),
                    new RotateCommand(drivebase, 148),
                    new TimedDriveForwardCommandGroup(3.0, 0.15, drivebase),
                    new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
                   );
    }
}
// Drive forward 2.92 ft and start collector
// Drive backwards 6 ft
// Rotate 170 degrees clockwise
// Drive forward slowly for a certain amount of time
// Shoot both balls high for a certain amount of time