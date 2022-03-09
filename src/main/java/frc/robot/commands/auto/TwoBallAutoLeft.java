package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.commands.drivebase.RotateCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class TwoBallAutoLeft extends SequentialCommandGroup
{
    public TwoBallAutoLeft(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands(new DriveAndCollectCommandGroup(drivebase, collector, Constants.AUTO_LEFT_DRIVE_AND_COLLECT_DISTANCE, shooter),
                    new DriveDistanceCommand(drivebase, Constants.AUTO_LEFT_DRIVE_DISTANCE),
                    new RotateCommand(drivebase, Constants.AUTO_LEFT_ROTATE),
                    new TimedDriveForwardCommandGroup(Constants.AUTO_LEFT_TIMED_DRIVE_FORWARD_HOW_LONG_TO_RUN,
                            Constants.AUTO_LEFT_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE, drivebase),
                    new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
                   );
    }
}
// Drive forward 2.92 ft and start collector
// Drive backwards 6 ft
// Rotate 170 degrees clockwise
// Drive forward slowly for a certain amount of time
// Shoot both balls high for a certain amount of time