package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.auto.GrabBall;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;

public class DriveAndCollectCommandGroup extends ParallelCommandGroup
{
    public DriveAndCollectCommandGroup(Drivebase drivebase, Collector collector, Double distance)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new DriveDistanceCommand(drivebase, distance), new GrabBall(collector));
    }
}