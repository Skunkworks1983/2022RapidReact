package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.RotateCommand;
import frc.robot.commands.SpinUpFlyWheelAndShootAllBallsHighCommandGroup;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class TwoBallAutoRight extends SequentialCommandGroup
{
    public TwoBallAutoRight(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands
                (
                        new DriveDistanceCommand(drivebase, 2.92),
                        new GrabBall(collector, shooter, true),
                        new DriveDistanceCommand(drivebase, -2.92),
                        new RotateCommand(drivebase, -90),
                        new DriveDistanceCommand(drivebase, -0.5),
                        new RotateCommand(drivebase, -69),
                        new SpinUpFlyWheelAndShootAllBallsHighCommandGroup(shooter)
                        );
        System.out.println("2autoRight over");
    }
}
