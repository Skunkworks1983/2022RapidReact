package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class SpinUpMotorCommand extends CommandBase
{
    private double setpoint;
    public SpinUpMotorCommand(Shooter s, Double speed)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        shooter = s;
        setpoint = speed;
    }
    Shooter shooter;
    @Override
    public void initialize()
    {
        shooter.setFlyWheel(setpoint);
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return shooter.getFlyWheelSpeed() > setpoint * 0.99999;
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
