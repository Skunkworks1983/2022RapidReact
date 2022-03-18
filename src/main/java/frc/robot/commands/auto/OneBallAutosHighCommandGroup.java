package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.commands.shooter.LoadFirstBallCommand;
import frc.robot.commands.shooter.SpinUpFlyWheelAndShootAllBallsHighCommandGroup;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class OneBallAutosHighCommandGroup extends SequentialCommandGroup
{
    public OneBallAutosHighCommandGroup(Shooter shooter, Drivebase drivebase)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter),
              new DriveDistanceCommand(drivebase, 5)
              );
    }
}