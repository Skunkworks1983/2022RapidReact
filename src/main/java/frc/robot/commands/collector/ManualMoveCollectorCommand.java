package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector.Collector;


public class ManualMoveCollectorCommand extends CommandBase
{
    Collector collector;
    double speed;

    public ManualMoveCollectorCommand(double speed, Collector collector)
    {
        addRequirements(collector);
        this.collector = collector;
        this.speed = speed;
    }

    @Override
    public void initialize()
    {
        collector.setCollectorAngleSpeed(speed);
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {
        collector.setCollectorAngleSpeed(0);
    }
}
