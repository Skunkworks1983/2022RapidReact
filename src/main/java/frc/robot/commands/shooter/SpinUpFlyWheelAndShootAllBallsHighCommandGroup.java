package frc.robot.commands.shooter;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;

public class SpinUpFlyWheelAndShootAllBallsHighCommandGroup extends SequentialCommandGroup
{
    public SpinUpFlyWheelAndShootAllBallsHighCommandGroup(Shooter s)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand())
        super(new SpinUpFlyWheelCommand(s , Constants.HIGH_GOAL_SPEED * 1.01), new HighShooterMotorCommand(s));
    }
}