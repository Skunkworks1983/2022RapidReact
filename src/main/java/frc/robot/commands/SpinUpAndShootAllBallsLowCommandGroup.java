package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;

public class SpinUpAndShootAllBallsLowCommandGroup extends SequentialCommandGroup
{
    public SpinUpAndShootAllBallsLowCommandGroup(Shooter s)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new SpinUpMotorCommand(s , Constants.LOW_GOAL_SPEED * 1.01), new ShootAllBallsLowCommand(s));
    }
}