package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;


public class SpinUpFlyWheelCommand extends CommandBase
{
    private double setpoint;
    private int onTargetCount;
    private int onTargetThreshold = 3;
    public SpinUpFlyWheelCommand(Shooter s, Double speed)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        // no requirement because it needs to run at the same time as another command
        shooter = s;
        setpoint = speed;
    }
    Shooter shooter;
    @Override
    public void initialize()
    {
        shooter.setFlywheel(setpoint);
    }

    @Override
    public void execute()
    {
        System.out.println(shooter.getFlyWheelSpeed());
    }

    @Override
    public boolean isFinished()
    {
        if(shooter.getFlyWheelSpeed() > setpoint)
        {
            onTargetCount++;
        }
        else
        {
            onTargetCount = 0;
        }
        return onTargetCount == onTargetThreshold;
    }

    @Override
    public void end(boolean interrupted)
    {
        if (interrupted)
        {
        shooter.setFlywheel(0);
        }
    }
}
