package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.commands.shooter.LoadBothBallsCommandGroup;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class DriveAndCollectCommandGroup extends ParallelCommandGroup
{
    public DriveAndCollectCommandGroup(Drivebase drivebase, Collector collector, Double distance, Shooter shooter)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super( new ParallelDeadlineGroup(new DriveDistanceCommand(drivebase, distance), new LoadBothBallsCommandGroup(shooter)));
                // ,new GrabBall(collector));
    }
}