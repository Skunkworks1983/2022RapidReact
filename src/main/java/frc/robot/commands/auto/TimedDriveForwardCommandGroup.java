package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.auto.TimerCommand;
import frc.robot.commands.drivebase.RunDriveBase;
import frc.robot.subsystems.Drivebase;

public class TimedDriveForwardCommandGroup extends ParallelDeadlineGroup
{
    public TimedDriveForwardCommandGroup(Double howLongToRun, Double howFastToDrive, Drivebase drivebase)
    {
        // TODO: Add your deadline and sequential commands in the super() call, e.g.
        //           super(new MyDeadlineCmd(), new OpenClawCommand(), new MoveArmCommand());
        //       Add the deadline command first. i.e. the command that upon
        //       ending will interrupt all other commands that are still running
        super(new TimerCommand(howLongToRun), new RunDriveBase(howFastToDrive, howFastToDrive, drivebase));
    }
}