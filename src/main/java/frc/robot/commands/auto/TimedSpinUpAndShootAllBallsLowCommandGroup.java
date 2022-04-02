package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.shooter.SpinUpFlyWheelAndShootAllBallsLowCommandGroup;
import frc.robot.subsystems.shooter.Shooter;

public class TimedSpinUpAndShootAllBallsLowCommandGroup extends ParallelDeadlineGroup
{
    public TimedSpinUpAndShootAllBallsLowCommandGroup(Shooter shooter)
    {
        // TODO: Add your deadline and sequential commands in the super() call, e.g.
        //           super(new MyDeadlineCmd(), new OpenClawCommand(), new MoveArmCommand());
        //       Add the deadline command first. i.e. the command that upon
        //       ending will interrupt all other commands that are still running
        super(new TimerCommand(3.0),
              new SpinUpFlyWheelAndShootAllBallsLowCommandGroup(shooter));
    }
}