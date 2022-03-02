package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.auto.TimerCommand;
import frc.robot.commands.shooter.SpinUpFlyWheelAndShootAllBallsHighCommandGroup;
import frc.robot.subsystems.shooter.Shooter;

public class TimedSpinUpAndShootAllBallsHighCommandGroup extends ParallelDeadlineGroup
{
    public TimedSpinUpAndShootAllBallsHighCommandGroup(Shooter shooter)
    {
        // TODO: Add your deadline and sequential commands in the super() call, e.g.
        //           super(new MyDeadlineCmd(), new OpenClawCommand(), new MoveArmCommand());
        //       Add the deadline command first. i.e. the command that upon
        //       ending will interrupt all other commands that are still running
        super(new TimerCommand(3.0), new SpinUpFlyWheelAndShootAllBallsHighCommandGroup(shooter));
    }
}