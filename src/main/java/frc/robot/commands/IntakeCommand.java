package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class IntakeCommand extends CommandBase
{
    private final Collector subsystem;
    private double speed;

     public IntakeCommand(Collector subsystem, double speed)
     {
         this.subsystem = subsystem;
         this.speed = speed;
     }

    @Override
    public void initialize()
    {
        super.initialize();
        System.out.println("initialized");
    }

    @Override
    public void execute()
    {
        super.execute();
        subsystem.collectBalls(speed);
        System.out.println("executed");
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
        subsystem.collectBalls(0);
        System.out.println("ended yay!");
    }
}