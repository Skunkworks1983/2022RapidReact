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
        System.out.println("raising climber arm");
        climber.setArm(true);
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
        System.out.println("lowering climber arm");
        climber.setArm(false);
    }
}
