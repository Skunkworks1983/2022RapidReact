package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class Intake extends CommandBase
{
    private final Collector subsystem;

     public Intake(Collector subsystem)
     {
         this.subsystem = subsystem;
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
    } // wheel stuff yay

    @Override
    public boolean isFinished()
    {
        return super.isFinished();
    } //replace "super.isFinished()" with real thing

    @Override
    public void end(boolean interrupted)
    {
        super.end(interrupted);
    }
}
