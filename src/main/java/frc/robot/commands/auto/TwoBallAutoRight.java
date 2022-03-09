package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.commands.drivebase.RotateCommand;
import frc.robot.commands.shooter.SpinUpFlyWheelAndShootAllBallsHighCommandGroup;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class TwoBallAutoRight extends SequentialCommandGroup
{
    public TwoBallAutoRight(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands
                (
                        new DriveAndCollectCommandGroup(drivebase, collector,
                                                        Constants.AUTO_RIGHT_DRIVE_AND_COLLECT_DISTANCE, shooter),
                        new DriveDistanceCommand(drivebase, Constants.AUTO_RIGHT_DRIVE_DISTANCE),
                        new RotateCommand(drivebase, Constants.AUTO_RIGHT_ROTATE),
                        new TimedDriveForwardCommandGroup(Constants.AUTO_RIGHT_TIMED_DRIVE_FORWARD_HOW_LONG_TO_RUN,
                                                          Constants.AUTO_RIGHT_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE, drivebase),
                        new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
                );
    }
}
