package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;


public class ManualCollectorCommand extends CommandBase
{
    public Collector collector;
    public boolean moveDownward;
    public double speed;

    public ManualCollectorCommand(Collector collector, boolean moveDownward)
    {
        this.collector = collector;
        this.moveDownward = moveDownward;
    }


    @Override
    public void initialize()
    {
        speed = 0.1; //todo change to real speed
    }

    @Override
    public void execute()
    {
        if (moveDownward)
        {
            collector.setCollectorAngleSpeed(-speed);
        }
        else
        {
            collector.setCollectorAngleSpeed(speed);
        }
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
