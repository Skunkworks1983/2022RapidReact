package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class LoadFirstBallCommand extends CommandBase
{

    public LoadFirstBallCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        shooter = s;
        addRequirements();
        // no requirement because it needs to run at the same time as another command
    }
    private Shooter shooter;

    //Runs both Indexer and LiftBall to bring the first ball to the top sensor (right before flywheel)
    @Override
    public void initialize()
    {
        shooter.setIndexer(Constants.INDEXER_LOAD_SPEED);
        shooter.setLiftBall(Constants.LIFT_BALL_LOAD_SPEED);
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        if (shooter.isBallBeforeFlyWheel())
        {
            System.out.println("First Ball Is Finished");
        }
        return shooter.isBallBeforeFlyWheel();
    }

    @Override
    public void end(boolean interrupted)
    {
        shooter.setIndexer(0);
        shooter.setLiftBall(0);
    }
}
