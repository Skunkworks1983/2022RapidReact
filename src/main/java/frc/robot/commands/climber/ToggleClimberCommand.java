package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.services.Oi;
import frc.robot.subsystems.climber.Climber;


public class ToggleClimberCommand extends CommandBase
{
    Climber climber;
    Oi oi;

    public ToggleClimberCommand(Climber climber, Oi oi)
    {
        this.climber = climber;
        this.oi = oi;
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
        return !oi.isToggleClimberPressed();
    }

    @Override
    public void end(boolean interrupted)
    {
        climber.ToggleArm();
    }
}
