package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.RunFlyWheelCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;

public class ShootBall extends SequentialCommandGroup
{
    public ShootBall(Shooter shooter)
    {
        addCommands
                (
                        new RunFlyWheelCommand(shooter, Constants.HIGH_GOAL_SPEED)
                );
    }
}