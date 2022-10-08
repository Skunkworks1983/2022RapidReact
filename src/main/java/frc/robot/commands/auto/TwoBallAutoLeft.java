package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.collector.MoveCollectorMotorControllerCommand;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.commands.drivebase.RotateCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class TwoBallAutoLeft extends SequentialCommandGroup
{
    public TwoBallAutoLeft(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands(new MoveCollectorMotorControllerCommand(collector, true),
                    //Moves collector down
                    new DriveAndCollectCommandGroup(drivebase, shooter, collector,
                                                    Constants.Drivebase.AUTO_LEFT_DRIVE_AND_COLLECT_DISTANCE,
                                                    -0.5),
                    //Drives forward and starts collecting motors
                    new TimedCollectCommandGroup(2.5, collector, Constants.Collector.COLLECTOR_INTAKE_SPEED, shooter),
                    //TimedCollectCommandGroup collects for a certain amount of time in one spot without leaving
                    new MoveCollectorMotorWIthTimeOutCommand(collector, false,.5),
                    //Moves collector up
                    new RotateCommand(drivebase, Constants.Drivebase.AUTO_LEFT_ROTATE),
                    //move collector up after spin
                    new MoveCollectorMotorWIthTimeOutCommand(collector, false, 1),
                    //Up
                    new DriveDistanceWithTimeOutCommandGroup(drivebase,Constants.Drivebase.AUTO_LEFT_RETURN_HUB_DISTANCE, Constants.Drivebase.AUTO_LEFT_RETURN_HUB_TIMEOUT),
                    //new TimedDriveForwardCommandGroup(Constants.Drivebase.AUTO_LEFT_RETURN_HUB_DISTANCE,
                    //        Constants.Drivebase.AUTO_LEFT_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE, drivebase),
                    //Drives forward for a certain amount of time
                    new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
                    //Shoot balls in high hub for a certain amount of time
                   );
    }
}
// Drive forward 2.92 ft and start collector
// Drive backwards 6 ft
// Rotate 170 degrees clockwise
// Drive forward slowly for a certain amount of time
// Shoot both balls high for a certain amount of time