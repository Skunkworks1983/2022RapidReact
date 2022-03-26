package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.climber.Climber;


public class ToggleClimberCommand extends CommandBase
{
    Climber climber;

    public ToggleClimberCommand(Climber climber)
    {
        this.climber = climber;
        addRequirements();
    }

    @Override
    public void initialize()
    {
        climber.ToggleArm();
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
