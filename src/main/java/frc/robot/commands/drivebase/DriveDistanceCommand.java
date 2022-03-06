package frc.robot.commands.drivebase;

import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


public class DriveDistanceCommand extends CommandBase
{
    private final Drivebase drivebase;
    private final double distanceFT;
    private double startDistanceFT;
    private double finishDistanceFT;
    private int direction;
    private double startDegree;
    private double KPDistance;
    private double KPAngle;
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
        this.drivebase = drivebase;
        this.distanceFT = distanceFT;
        addRequirements(drivebase);
    }

    @Override
    public void initialize()
    {
        startDistanceFT = drivebase.getPosLeft();
        finishDistanceFT = startDistanceFT+distanceFT;
        startDegree = drivebase.getHeading();
        KPDistance = 0.05;
        KPAngle = 0.04; //todo <-- 0.2 is too high, also 0.04 is too low
        KF = 0.2;
        if(distanceFT > 0)
        {
            direction = 1;
        }
        else
        {
            direction = -1;
        }
        System.out.println("moving from " +startDistanceFT + " to " + finishDistanceFT);
    }

    @Override
    public void execute()
    {
        double error = finishDistanceFT - drivebase.getPosLeft();
        double speed = KPDistance * error + KF * direction;
        double speedLeft = speed + Math.max(Math.min(KPAngle*(startDegree - drivebase.getHeading()), 0.25), -0.25);
        double speedRight = speed - Math.max(Math.min(KPAngle*(startDegree - drivebase.getHeading()), 0.25), -0.25);
        drivebase.runMotor(speedLeft, speedRight);
        SmartDashboard.putNumber("FT moved", drivebase.getPosLeft()-startDistanceFT);
    }

    @Override
    public boolean isFinished()
    {
        return Math.abs(drivebase.getPosLeft() - finishDistanceFT)< 0.05;
    }

    @Override
    public void end(boolean interrupted)
    {
        drivebase.runMotor(0, 0);
        System.out.println("Ended at: "+drivebase.getPosLeft());
    }
}
