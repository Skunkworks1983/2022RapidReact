package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.shooter.RunFlyWheelCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;

public class ShootBall extends SequentialCommandGroup
{
    //NOTE:DON'T use this command(it should be deleted) use shoot
    // SpinUpFlyWheelAndShootAllBallsHighCommandGroup or SpinUpFlyWheelAndShootAllBallsLowCommandGroup!
    public ShootBall(Shooter shooter)
    {
        addCommands
                (
                        new RunFlyWheelCommand(shooter, Constants.Shooter.HIGH_GOAL_SPEED)
                );
    }
}