package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.UpAndDownCollector;

public class UpAndDownCollectorCommand extends CommandBase
{
    private final UpAndDownCollector subSystem;
    private boolean raised;

    public UpAndDownCollectorCommand (UpAndDownCollector subSystem, boolean raised)
    {
        this.subSystem = subSystem;
        this.raised = raised; //fixed ez ez
    }

    @Override
    public void initialize()
    {
        super.initialize();
        subSystem.raiseCollector(raised);
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
