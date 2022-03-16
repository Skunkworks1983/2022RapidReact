package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector.Collector;


public class CollectorEncoderResetCommand extends CommandBase
{
    private Collector collector;
    public CollectorEncoderResetCommand(Collector collector)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(collector);
        this.collector = collector;
    }

    @Override
    public void initialize()
    {
        collector.collectorEncoderReset();
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
