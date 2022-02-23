package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;


public class LoadSecondBallCommand extends CommandBase
{

    public LoadSecondBallCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        // no requirement because it needs to run at the same time as another command
        shooter = s;
    }
    private Shooter shooter;
    //Runs only Indexer to bring the ball to the second sensor
    @Override
    public void initialize()
    {
        shooter.setIndexer(.5);
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        System.out.println("Is Finished");
        return shooter.isBallAtIntake();
    }

    @Override
    public void end(boolean interrupted)
    {
        shooter.setIndexer(0);
    }
}
