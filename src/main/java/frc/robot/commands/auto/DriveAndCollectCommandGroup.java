package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.shooter.Shooter;

public class DriveAndCollectCommandGroup extends ParallelCommandGroup
{
    public DriveAndCollectCommandGroup(Drivebase drivebase, Shooter shooter, Collector collector,
                                       Double distance, Double speed, Boolean ball2)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new DriveDistanceCommand(drivebase, distance),
              new LoadBothBallsAndCollectCommandGroup(shooter, collector, speed, ball2));
    }
}