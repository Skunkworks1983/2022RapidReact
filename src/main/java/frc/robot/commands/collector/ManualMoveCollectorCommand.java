package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector.Collector;
import frc.robot.services.Oi;

public class ManualMoveCollectorCommand extends CommandBase
{
    Collector collector;
    double speed;
    private Oi oi;

    public ManualMoveCollectorCommand(double speed, Collector collector, Oi oi)
    {
        addRequirements(collector);
        this.collector = collector;
        this.speed = speed;
        this.oi = oi;
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {
        collector.setCollectorAngleSpeed(speed);
    }

    @Override
    public boolean isFinished()
    {
        return !oi.isEnableManualControlsPressed();
    }

    @Override
    public void end(boolean interrupted)
    {
        collector.setCollectorAngleSpeed(0);
    }
}
