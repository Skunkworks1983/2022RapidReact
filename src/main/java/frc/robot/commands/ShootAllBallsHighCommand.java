package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class ShootAllBallsHighCommand extends CommandBase
{

    public ShootAllBallsHighCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(shooter);
        shooter = s;
    }
    Shooter shooter;
    @Override
    public void initialize()
    {
        shooter.setFlywheel(Constants.HIGH_GOAL_SPEED);
        shooter.setLiftBall(.3);
        shooter.setIndexer(.3);
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
