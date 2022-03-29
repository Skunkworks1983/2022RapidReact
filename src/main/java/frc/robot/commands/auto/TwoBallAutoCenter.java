package frc.robot.commands.auto;

import frc.robot.commands.collector.MoveCollectorMotorControllerCommand;
import frc.robot.commands.drivebase.RotateCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.collector.Collector;
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
                new MoveCollectorMotorControllerCommand(collector, true),
                new DriveDistanceCommand(drivebase, Constants.Drivebase.AUTO_CENTER_DRIVE_DISTANCE_ONE),
                //new DriveDistanceAndMoveCollectorCommandGroup(drivebase, collector,
                    //Constants.AUTO_CENTER_DRIVE_DISTANCE_ONE, true),
                new RotateCommand(drivebase, Constants.Drivebase.AUTO_CENTER_ROTATE_ONE),
                new DriveAndCollectCommandGroup(drivebase, shooter, collector,
                                                Constants.Drivebase.AUTO_CENTER_DRIVE_DISTANCE_ONE,
                                                -0.5, true),
                //new DriveAndCollectAndMoveCollectorCommandGroup(drivebase, collector,
                                                                //Constants.Drivebase.AUTO_CENTER_DRIVE_AND_COLLECT_DISTANCE,
                                                                //shooter, true),
                new TimedCollectCommandGroup(2.5, collector, true, -0.5, shooter),
                //TimedCollectCommandGroup collects for a certain amount of time in one spot without leaving
                new MoveCollectorMotorControllerCommand(collector, false),
                new RotateCommand(drivebase, Constants.Drivebase.AUTO_CENTER_ROTATE_TWO),
                new DriveDistanceCommand(drivebase, Constants.Drivebase.AUTO_CENTER_DRIVE_DISTANCE_TWO),
                //new DriveDistanceAndMoveCollectorCommandGroup(drivebase, collector,
                                                              //Constants.Drivebase.AUTO_CENTER_DRIVE_DISTANCE_TWO, false),
                new RotateCommand(drivebase, Constants.Drivebase.AUTO_CENTER_ROTATE_THREE),
                new TimedDriveForwardCommandGroup(Constants.Drivebase.AUTO_CENTER_TIMED_DRIVE_FORWARD_HOW_LONG_TO_RUN,
                                                  Constants.Drivebase.AUTO_CENTER_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE, drivebase),
                new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
        );
    }
}