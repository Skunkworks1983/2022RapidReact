package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


public class DriveDistanceCommand extends CommandBase
{
    private final Drivebase drivebase;
    private final double speed;
    private final double distanceFT;
    private double startDistanceFT;
    private int direction;
    private double startDegree;

    /**
     *
     * @param drivebase what drivebase to use
     * @param distanceFT The direction and distance in which to go
     * @param speed Should always be positive
     */
    public DriveDistanceCommand(Drivebase drivebase, double distanceFT, double speed)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements();
        this.drivebase = drivebase;
        this.distanceFT = distanceFT;
        this.speed = speed;
    }

    @Override
    public void initialize()
    {
        startDistanceFT = drivebase.getPosLeft();
        startDegree = drivebase.getHeading();

        if(distanceFT < 0)
        {
            direction = 1;
        }
        else
        {
            direction = -1;
        }
        drivebase.runMotor(speed*direction, speed*direction);
    }

    @Override
    public void execute()
    {

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
    }
}
