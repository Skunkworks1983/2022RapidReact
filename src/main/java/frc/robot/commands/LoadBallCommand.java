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

    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
