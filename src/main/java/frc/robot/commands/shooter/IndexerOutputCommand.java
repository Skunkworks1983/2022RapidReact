package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class IndexerOutputCommand extends CommandBase
{
    public IndexerOutputCommand(Shooter s)
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
        shooter.setIndexer(-Constants.Shooter.INDEXER_LOAD_SPEED);
        shooter.setLiftBall(-Constants.Shooter.LIFT_BALL_LOAD_SPEED);
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
        shooter.setIndexer(0);
        shooter.setLiftBall(0);
    }
}
