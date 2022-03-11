package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class LoadSecondBallCommand extends CommandBase
{

    public LoadSecondBallCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        shooter = s;
        addRequirements();
        // no requirement because it needs to run at the same time as another command
    }
    private Shooter shooter;
    //Runs only Indexer to bring the ball to the second sensor
    @Override
    public void initialize()
    {
        shooter.setIndexer(Constants.INDEXER_LOAD_SPEED);
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished() {
        if (shooter.isBallAtIntake())
        {
            System.out.println("Second ball Is Finished");
        }
        return shooter.isBallAtIntake();
    }

    @Override
    public void end(boolean interrupted)
    {
        shooter.setIndexer(0);
    }
}
