package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;


public class TimerCommand extends CommandBase
{
    private Double doneTime;
    private Double howLongToWait;
    public TimerCommand(Double howLongToWait)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        this.howLongToWait = howLongToWait;
    }

    @Override
    public void initialize()
    {
        doneTime = Timer.getFPGATimestamp() + howLongToWait;
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
