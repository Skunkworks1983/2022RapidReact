package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;


public class LoadFirstBallCommand extends CommandBase
{

    public LoadFirstBallCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        shooter = s;
    }
    private Shooter shooter;

    @Override
    public void initialize()
    {
        shooter.setIndexer(.4);
        shooter.setLiftBall(.4);
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        System.out.println("Is Finished");
        return shooter.isBallBeforeFlyWheel();
    }

    @Override
    public void end(boolean interrupted)
    {
        shooter.setIndexer(0);
        shooter.setLiftBall(0);
    }
}
