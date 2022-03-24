package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.collector.MoveCollectorMotorControllerCommand;
import frc.robot.commands.drivebase.RotateCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class TwoBallAutoRight extends SequentialCommandGroup
{
    public TwoBallAutoRight(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands
                (
                        new MoveCollectorMotorControllerCommand(collector, true),
                        new DriveAndCollectCommandGroup(drivebase, shooter, collector,
                                                        Constants.Drivebase.AUTO_RIGHT_DRIVE_AND_COLLECT_DISTANCE, -0.5, true),
                        //new DriveAndCollectAndMoveCollectorCommandGroup(drivebase, collector,
                                                                        //Constants.Drivebase.AUTO_RIGHT_DRIVE_AND_COLLECT_DISTANCE,
                                                                        //shooter, true),
                        new TimedCollectCommandGroup(2.5, collector, true, -0.5,
                                                     shooter),
                        new MoveCollectorMotorControllerCommand(collector, false),
                        //new DriveDistanceAndMoveCollectorCommandGroup(drivebase, collector,
                                //Constants.Drivebase.AUTO_RIGHT_DRIVE_DISTANCE, false),
                        new RotateCommand(drivebase, Constants.Drivebase.AUTO_RIGHT_ROTATE),
                        new TimedDriveForwardCommandGroup(Constants.Drivebase.AUTO_RIGHT_TIMED_DRIVE_FORWARD_HOW_LONG_TO_RUN,
                                                          Constants.Drivebase.AUTO_RIGHT_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE,
                                                          drivebase),
                        new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
                );
    }
}
