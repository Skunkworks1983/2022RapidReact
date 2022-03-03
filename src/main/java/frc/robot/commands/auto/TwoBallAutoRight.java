package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.commands.drivebase.RotateCommand;
import frc.robot.commands.shooter.SpinUpFlyWheelAndShootAllBallsHighCommandGroup;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class TwoBallAutoRight extends SequentialCommandGroup
{
    public TwoBallAutoRight(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands
                (
                        new DriveDistanceCommand(drivebase, 3),
                        //new GrabBall(collector, shooter, true),
                        new DriveDistanceCommand(drivebase, -3),
                        new RotateCommand(drivebase, -159),
                        new TimedDriveForwardCommandGroup(3.0, 0.2, drivebase)
                        //new SpinUpFlyWheelAndShootAllBallsHighCommandGroup(shooter)
                        );
    }
}
