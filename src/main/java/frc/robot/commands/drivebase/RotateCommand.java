package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


public class RotateCommand extends CommandBase
{
    private final Drivebase drivebase;
    private double degree;
    private double startDegree;
    private double finishDegree;
    private double KP;
    private double KF;
    private int direction;
    private int onTargetCount;
    private int onTargetThreshold = 3;

    public RotateCommand(Drivebase drivebase, double degree)
    {
        addRequirements();
        this.drivebase = drivebase;
        this.degree = degree;
    }

    @Override
    public void initialize()
    {
        startDegree = drivebase.getHeading();
        finishDegree = startDegree + degree;
        KP = 0.005;
        KF = 0.2;
        System.out.println("turning to: " + (finishDegree));
        System.out.println("starting speed is: " + (KP * (finishDegree - drivebase.getHeading())) + ", starting degree is: " + startDegree);
    }

    @Override
    public void execute()
    {
        double error = finishDegree - drivebase.getHeading();
        double speed = (KP * error) + Math.copySign(KF, error);
        drivebase.runMotor(speed, -speed);
        SmartDashboard.putNumber("angle", drivebase.getHeading());
    }

    @Override
    public boolean isFinished()
    {
        if(Math.abs(drivebase.getHeading() - finishDegree)< 0.8)
        {
            onTargetCount++;
        }
        else
        {
            onTargetCount = 0;
        }
        return onTargetCount == onTargetThreshold;
//        if(degree > 0)
//        {
//            return drivebase.getHeading() > finishDegree;
//        }
//        else
//        {
//            return drivebase.getHeading() < finishDegree;
//        }
    }

    @Override
    public void end(boolean interrupted)
    {
        drivebase.runMotor(0, 0);
        System.out.println("ending, final degree: " + drivebase.getHeading());
    }
}