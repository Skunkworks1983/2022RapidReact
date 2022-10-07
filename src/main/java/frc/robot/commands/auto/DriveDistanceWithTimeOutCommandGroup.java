package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;

public class DriveDistanceWithTimeOutCommandGroup extends ParallelRaceGroup
{
    public DriveDistanceWithTimeOutCommandGroup(Drivebase drivebase,double dist,double time)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new DriveDistanceCommand(drivebase, dist),new TimerCommand(time));
    }
}