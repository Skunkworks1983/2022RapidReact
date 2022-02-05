package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.services.Oi;
import frc.robot.subsystems.Collector;

public class IntakeCommand extends CommandBase
{
    private final Collector subsystem;
    private double speed;
    private Oi oi;

     public IntakeCommand(Collector subsystem, Oi oi, double speed)
     {
         this.subsystem = subsystem;
         this.speed = speed;
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
        if ()
        {
        subsystem.collectBalls(speed);
        }
    } // wheel stuff yay

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {
        super.end(interrupted);
    }
}
