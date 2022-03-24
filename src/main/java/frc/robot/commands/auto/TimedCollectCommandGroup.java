package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.collector.IntakeCommand;
import frc.robot.commands.collector.MoveCollectorMotorControllerCommand;
import frc.robot.commands.shooter.LoadBothBallsCommandGroup;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.shooter.Shooter;

public class TimedCollectCommandGroup extends ParallelDeadlineGroup
{
    public TimedCollectCommandGroup(Double howLongToWait, Collector collector, Boolean ball2,
            Double speed, Shooter shooter)
    {
        // TODO: Add your deadline and sequential commands in the super() call, e.g.
        //           super(new MyDeadlineCmd(), new OpenClawCommand(), new MoveArmCommand());
        //       Add the deadline command first. i.e. the command that upon
        //       ending will interrupt all other commands that are still running
        super(new TimerCommand(howLongToWait),
              new IntakeCommand(collector, shooter, speed, ball2),
              new LoadBothBallsCommandGroup(shooter)
             );
    }
}