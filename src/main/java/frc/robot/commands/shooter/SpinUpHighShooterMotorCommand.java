package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class SpinUpHighShooterMotorCommand extends CommandBase
{

    public SpinUpHighShooterMotorCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        shooter = s;
        addRequirements(shooter);
    }
    Shooter shooter;
    @Override
    public void initialize()
    {
        shooter.setFlywheel(Constants.HIGH_GOAL_SPEED);
        shooter.setLiftBall(Constants.LIFT_BALL_LOAD_SPEED);
        shooter.setIndexer(Constants.INDEXER_LOAD_SPEED);
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
        shooter.setFlywheel(0);
        shooter.setLiftBall(0);
        shooter.setIndexer(0);
    }
}
