package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import frc.robot.commands.auto.TimerCommand;
import frc.robot.commands.drivebase.RunDriveBase;
import frc.robot.subsystems.Drivebase;

public class TimedDriveForwardCommandGroup extends ParallelDeadlineGroup
{
    public TimedDriveForwardCommandGroup(Double howLongToRun, Double howFastToDrive, Drivebase drivebase)
    {

        super(new TimerCommand(howLongToRun), new RunDriveBase(howFastToDrive, howFastToDrive, drivebase));
    }
}