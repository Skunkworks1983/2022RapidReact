package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class ManualLoadBallCommand extends CommandBase
{

    public ManualLoadBallCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        // no requirement because it needs to run at the same time as another command
        shooter = s;
    }
    private Shooter shooter;

    @Override
    public void initialize()
    {
        if ((!shooter.isBallBeforeFlyWheel()) && (!shooter.isBallAtIntake()))
        {
            shooter.setIndexer(Constants.Shooter.INDEXER_LOAD_SPEED);
            shooter.setLiftBall(Constants.Shooter.LIFT_BALL_LOAD_SPEED);
        }
        else if ((!shooter.isBallBeforeFlyWheel()) && shooter.isBallAtIntake())
        {
            shooter.setIndexer(Constants.Shooter.INDEXER_LOAD_SPEED);
            shooter.setLiftBall(Constants.Shooter.LIFT_BALL_LOAD_SPEED);
        }
        else if (shooter.isBallBeforeFlyWheel() && (!shooter.isBallAtIntake()))
        {
            shooter.setIndexer(Constants.Shooter.INDEXER_LOAD_SPEED);
        }
    }

    @Override
    public void execute()
    {
        if (shooter.isBallBeforeFlyWheel())
        {
            shooter.setLiftBall(0);
        }
        else if (shooter.isBallBeforeFlyWheel() && shooter.isBallAtIntake())
        {
            shooter.setIndexer(0);
            shooter.setLiftBall(0);
        }
    }

    @Override
    public boolean isFinished()
    {
        return shooter.isBallBeforeFlyWheel() && shooter.isBallAtIntake();
    }

    @Override
    public void end(boolean interrupted)
    {
        shooter.setIndexer(0);
        shooter.setLiftBall(0);
    }
}
