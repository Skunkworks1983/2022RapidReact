package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.services.Oi;

public class buttonPressDetect extends CommandBase
{
    private Oi oi;
    private boolean

    public buttonPressDetect(Oi oi)
    {
        this.oi = oi;
    }

    @Override
    public void initialize()
    {
        super.initialize();
    }

    @Override
    public void execute()
    {
        super.execute();
    }

    @Override
    public boolean isFinished()
    {
        return super.isFinished();
    }

    @Override
    public void end(boolean interrupted)
    {
        super.end(interrupted);
    }
}
