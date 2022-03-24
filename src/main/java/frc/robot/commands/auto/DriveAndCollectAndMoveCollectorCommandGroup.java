package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class DriveAndCollectAndMoveCollectorCommandGroup extends ParallelCommandGroup
{
    public DriveAndCollectAndMoveCollectorCommandGroup(Drivebase drivebase, Collector collector,
                                                       Double distance, Shooter shooter, Boolean moveDownward)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new ParallelDeadlineGroup(new DriveDistanceAndMoveCollectorCommandGroup(drivebase, collector,
                distance, moveDownward),
                //new DriveDistanceCommand(drivebase, distance),
                new LoadBothBallsAndCollectCommandGroup(shooter, collector, -0.3, true)
                ));
    }
}