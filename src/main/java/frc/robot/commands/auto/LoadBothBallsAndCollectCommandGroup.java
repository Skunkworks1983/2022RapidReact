package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.collector.IntakeCommand;
import frc.robot.commands.shooter.LoadFirstBallCommand;
import frc.robot.commands.shooter.LoadSecondBallCommand;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.shooter.Shooter;

public class LoadBothBallsAndCollectCommandGroup extends ParallelCommandGroup
{
    public LoadBothBallsAndCollectCommandGroup(Shooter shooter, Collector collector)
    {
        super(new LoadFirstBallCommand(shooter), new LoadSecondBallCommand(shooter),
                new IntakeCommand(collector, shooter, 0.5, true));
    }
}