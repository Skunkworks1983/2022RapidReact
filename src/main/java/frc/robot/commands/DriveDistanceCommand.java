package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


public class DriveDistanceCommand extends CommandBase
{
    private Drivebase drivebase;
    private double distanceFT;
    private double startDistanceFT;
    private double finishDistanceFT;
    private int direction;
    private double KP;
    private double KF;

    /**
     *
     * @param drivebase what drivebase to use
     * @param distanceFT The direction and distance in which to go
     */
    public DriveDistanceCommand(Drivebase drivebase, double distanceFT)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        this.drivebase = drivebase;
        this.distanceFT = distanceFT;
    }

    @Override
    public void initialize()
    {
        startDistanceFT = drivebase.getPosLeft();
        finishDistanceFT = startDistanceFT+distanceFT;
        KP = 0.1;
        if(distanceFT > 0)
        {
            direction = 1;
        }
        else
        {
            direction = -1;
        }
        System.out.println("drivebase starting, starting distance: "+startDistanceFT);
    }

    @Override
    public void execute()
    {
        double error = finishDistanceFT - drivebase.getPosLeft();
        double speed = Math.max((KP * error), 0.2);
        drivebase.runMotor(speed*direction, speed*direction);
    }

    @Override
    public boolean isFinished()
    {
        if(distanceFT < 0)
        {
            return drivebase.getPosLeft() < distanceFT + startDistanceFT;
        }
        else
        {
            return drivebase.getPosLeft() > distanceFT + startDistanceFT;
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        drivebase.runMotor(0, 0);
        System.out.println("Ended at: "+drivebase.getPosLeft());
    }
}
