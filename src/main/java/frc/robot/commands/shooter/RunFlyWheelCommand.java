package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class RunFlyWheelCommand extends CommandBase
{
    private Shooter shooter;
    private double setpoint;
    public RunFlyWheelCommand(Shooter s, Double speed)
    {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        // no requirement because it needs to run at the same time as another command
        shooter = s;
        setpoint = speed;
    }

    @Override
    public void initialize()
    {
        System.out.printf("KP: %f\t KF: %f\n", Constants.Shooter.FLY_WHEEL_KP, Constants.Shooter.FLY_WHEEL_KF);
        shooter.setFlywheel(setpoint);
    }

    @Override
    public void execute()
    {
        System.out.printf("Speed %f\n", shooter.getFlyWheelSpeed());
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
        shooter.setFlywheel(0);
    }
}
