package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;


public class ResetCollectorEncoderCommand extends CommandBase
{

    private Collector collector;

    public ResetCollectorEncoderCommand(Collector collector)
    {
        this.collector = collector;
    }

    @Override
    public void initialize()
    {
        collector.resetCollectorEncoder();
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
