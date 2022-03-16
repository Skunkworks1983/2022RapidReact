package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.collector.Collector;
import frc.robot.services.Oi;

public class ManualIntakeCommand extends CommandBase
{
    private Collector collector;
    private double speed;
    private Oi oi;
    public ManualIntakeCommand(Collector collector, double speed, Oi oi)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
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
        collector.collectBalls(speed);
    }

    @Override
    public boolean isFinished()
    {
        return !oi.isEnableManualControlsPressed();
    }

    @Override
    public void end(boolean interrupted)
    {
        collector.collectBalls(0);
    }
}
