package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.shooter.Shooter;

public class IntakeCommand extends CommandBase
{
    private final Collector collector;
    private final Shooter shooter;
    private double speed;
    private boolean ball2;

     public IntakeCommand(Collector collector, Shooter shooter, double speed, boolean ball2)
     {
         this.collector = collector;
         this.shooter = shooter;
         this.speed = speed;
         this.ball2 = ball2;
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
        collector.collectBalls(speed);
        System.out.println("executed");
    } // wheel stuff yay

    @Override
    public boolean isFinished()
    {
        if (ball2)
        {
            return shooter.isBallAtIntake();
        }
        else
        {
            return shooter.isBallBeforeFlyWheel();
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        super.end(interrupted);
        collector.collectBalls(0);
        System.out.println("ended yay!");
    }
}
