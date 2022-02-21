package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.shooter.Shooter;

public class ShootsAllBallsForHighCommandGroup extends SequentialCommandGroup
{
    public ShootsAllBallsForHighCommandGroup(Shooter s)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new RunHighGoalFlyWheelCommand(s), new WaitCommand(5), new ShootAllBallsHighCommand(s));
    }
}