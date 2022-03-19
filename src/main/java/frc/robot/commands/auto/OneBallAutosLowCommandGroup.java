package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class OneBallAutosLowCommandGroup extends SequentialCommandGroup
{
    public OneBallAutosLowCommandGroup(Shooter shooter, Drivebase drivebase)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new TimedSpinUpAndShootAllBallsLowCommandGroup(shooter),
              new DriveDistanceCommand(drivebase, -8));
    }
}