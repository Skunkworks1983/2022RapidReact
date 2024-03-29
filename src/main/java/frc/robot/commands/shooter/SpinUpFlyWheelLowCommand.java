package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;

public class SpinUpFlyWheelLowCommand extends CommandBase
{

    public SpinUpFlyWheelLowCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        shooter = s;
    }
    private Shooter shooter;
    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {
        shooter.setFlywheel(Constants.Shooter.LOW_GOAL_SPEED);
        SmartDashboard.putNumber("FlyWheelSpeed", shooter.getFlyWheelSpeed());
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
