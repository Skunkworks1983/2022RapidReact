package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


public class DriveDistanceCommand extends CommandBase
{
    private Drivebase drivebase;
    private double speed;
    private double distanceFT;
    private double startDistanceFT;

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

    /**
     * The initial subroutine of a command.  Called once when the command is initially scheduled.
     */
    @Override
    public void initialize()
    {
        startDistanceFT = drivebase.getPosLeft();
        finishDistanceFT = startDistanceFT+distanceFT;
        KP = 0.1;
        if(distanceFT > 0)
        {
            drivebase.runMotor(speed, speed);
        }
        else
        {
            drivebase.runMotor(-speed, -speed);
        }

    }

    /**
     * The main body of a command.  Called repeatedly while the command is scheduled.
     * (That is, it is called repeatedly until {@link #isFinished()}) returns true.)
     */
    @Override
    public void execute()
    {
        double error = finishDistanceFT - drivebase.getPosLeft();
        double speed = Math.max((KP * error), 0.2);
        drivebase.runMotor(speed*direction, speed*direction);
    }

    /**
     * <p>
     * Returns whether this command has finished. Once a command finishes -- indicated by
     * this method returning true -- the scheduler will call its {@link #end(boolean)} method.
     * </p><p>
     * Returning false will result in the command never ending automatically. It may still be
     * cancelled manually or interrupted by another command. Hard coding this command to always
     * return true will result in the command executing once and finishing immediately. It is
     * recommended to use * {@link edu.wpi.first.wpilibj2.command.InstantCommand InstantCommand}
     * for such an operation.
     * </p>
     *
     * @return whether this command has finished.
     */
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

    /**
     * The action to take when the command ends. Called when either the command
     * finishes normally -- that is it is called when {@link #isFinished()} returns
     * true -- or when  it is interrupted/canceled. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the command.
     *
     * @param interrupted whether the command was interrupted/canceled
     */
    @Override
    public void end(boolean interrupted)
    {
        drivebase.runMotor(0, 0);
        System.out.println("Ended at: "+drivebase.getPosLeft());
    }
}
