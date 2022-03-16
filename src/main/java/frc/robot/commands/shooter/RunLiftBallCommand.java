package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class RunLiftBallCommand extends CommandBase {

    public RunLiftBallCommand(Shooter s)
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

    }

    @Override
    public void execute()
    {
        shooter.setLiftBall(Constants.Shooter.LIFT_BALL_LOAD_SPEED);
        System.out.println(shooter.getLiftBallSpeed());
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
        shooter.setLiftBall(0);
    }
}
