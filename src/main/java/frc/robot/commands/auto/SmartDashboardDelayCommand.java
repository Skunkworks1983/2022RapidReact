package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class SmartDashboardDelayCommand extends CommandBase
{
    private Double doneTime;
    private String delayName;
    public SmartDashboardDelayCommand(String delayName)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        this.delayName = delayName;
    }

    @Override
    public void initialize()
    {
        doneTime = Timer.getFPGATimestamp() + SmartDashboard.getNumber(delayName, 0);
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return Timer.getFPGATimestamp() >= doneTime;
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
