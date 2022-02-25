package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;


public class SpinUpFlyWheelCommand extends CommandBase
{
    private double setpoint;
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
        if(shooter.getFlyWheelSpeed() > setpoint * 0.99)
        {
            System.out.println( "spinupmotorcommandfinished " + shooter.getFlyWheelSpeed());
            return true;
        }
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {
        shooter.setFlywheel(0);
    }
}
