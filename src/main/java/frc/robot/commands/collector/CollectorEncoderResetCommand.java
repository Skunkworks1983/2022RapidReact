package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector.Collector;
import frc.robot.services.Oi;


public class CollectorEncoderResetCommand extends CommandBase
{
    private Collector collector;
    private Oi oi;
    public CollectorEncoderResetCommand(Collector collector, Oi oi)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(collector);
        this.collector = collector;
        this.oi = oi;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {
        collector.collectorEncoderReset();
    }

    @Override
    public boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return !oi.isEnableManualControlsPressed();
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
