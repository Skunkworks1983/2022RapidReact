package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.UpAndDownCollector;

public class UpAndDownCollectorCommand extends CommandBase
{
    private final UpAndDownCollector subSystem;
    private boolean upOrDown;

    public UpAndDownCollectorCommand (UpAndDownCollector subSystem, boolean upOrDown)
    {
        this.subSystem = subSystem;
        this.upOrDown = upOrDown;
    }

    @Override
    public void initialize()
    {
        super.initialize();
        subSystem.raiseCollector(upOrDown);
    }

    @Override
    public void execute()
    {
        super.execute();
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

    @Override
    public void end(boolean interrupted)
    {
        super.end(interrupted);
    }
}
