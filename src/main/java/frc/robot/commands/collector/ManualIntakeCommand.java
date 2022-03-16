package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.collector.Collector;

public class ManualIntakeCommand extends CommandBase
{
    private Collector collector;
    private double speed;
    public ManualIntakeCommand(Collector collector, double speed)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        this.collector = collector;
        this.speed = speed;
    }
    @Override
    public void initialize()
    {
        collector.collectBalls(speed);
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
        collector.collectBalls(0);
    }
}
