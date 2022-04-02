package frc.robot.commands.shooter;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;

public class ShootWhenReadyCommandGroup extends SequentialCommandGroup {
    public ShootWhenReadyCommandGroup(Shooter shooter) {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new SpinUpFlyWheelCommand(shooter),
              new ShootCommand(shooter, shooter.getTarget()));
    }
}