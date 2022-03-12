package frc.robot.commands.auto;

import frc.robot.commands.drivebase.RotateCommand;
import frc.robot.constants.Constants;
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
            //new DriveDistanceCommand(drivebase, Constants.AUTO_CENTER_DRIVE_DISTANCE_ONE),
                new DriveDistanceAndMoveCollectorCommandGroup(drivebase, collector,
                    Constants.AUTO_CENTER_DRIVE_DISTANCE_ONE, true),
            new RotateCommand(drivebase, Constants.AUTO_CENTER_ROTATE_ONE),
            new DriveAndCollectCommandGroup(drivebase, collector,
                                            Constants.AUTO_CENTER_DRIVE_AND_COLLECT_DISTANCE,
                    shooter, true),
            new RotateCommand(drivebase, Constants.AUTO_CENTER_ROTATE_TWO),
            new DriveDistanceAndMoveCollectorCommandGroup(drivebase, collector,
                    Constants.AUTO_CENTER_DRIVE_DISTANCE_TWO, false),
            new RotateCommand(drivebase, Constants.AUTO_CENTER_ROTATE_THREE),
            new TimedDriveForwardCommandGroup(Constants.AUTO_CENTER_TIMED_DRIVE_FORWARD_HOW_LONG_TO_RUN,
                    Constants.AUTO_CENTER_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE, drivebase),
            new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
        );
    }
}
