package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;


public class LoadBallCommand extends CommandBase
{

    public LoadBallCommand(Shooter s)
    {
        // each subsystem used by the command must be passed into the addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        shooter = s;
    }
    private Shooter shooter;

    @Override
    public void initialize()
    {
        if ((!shooter.isBallBeforeFlyWheel()) && (!shooter.isBallAtIntake()))
        {
            shooter.setIndexer(.5);
            shooter.setLiftBall(.5);
        }
        else if ((!shooter.isBallBeforeFlyWheel()) && shooter.isBallAtIntake())
        {
            shooter.setLiftBall(.5);
        }
        else if (shooter.isBallBeforeFlyWheel() && (!shooter.isBallAtIntake()))
        {
            shooter.setIndexer(.5);
        }
    }

    @Override
    public void execute()
    {
        if (shooter.isBallBeforeFlyWheel())
        {
            shooter.setLiftBall(0);
        }
    }

    @Override
    public boolean isFinished()
    {
        if (shooter.isBallBeforeFlyWheel() && shooter.isBallAtIntake())
        {
            shooter.setIndexer(0);
            shooter.setLiftBall(0);
        }
        return shooter.isBallBeforeFlyWheel() && shooter.isBallAtIntake();
    }

    @Override
    public void end(boolean interrupted)
    {
        shooter.setIndexer(0);
        shooter.setLiftBall(0);
    }
}
