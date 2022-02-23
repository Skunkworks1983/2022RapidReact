package frc.robot.commands;

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

    public RotateCommand(Drivebase drivebase, double degree)
    {
        addRequirements();
        this.drivebase = drivebase;
        this.degree = degree;
    }

    @Override
    public void initialize()
    {
        if(Math.abs(degree) > 180)
        {
            if(degree > 0)
            {
                degree = degree - 360;
            }
            else
            {
                degree = degree + 360;
            }
        }
        startDegree = drivebase.getHeading();
        finishDegree = startDegree + degree;
        KP = 0.005;
        KF = 0.15;
        System.out.println("turning to: " + (finishDegree));
        System.out.println("starting speed is: " + (KP * (finishDegree - drivebase.getHeading())) + ", starting degree is: " + startDegree);
    }

    @Override
    public void execute()
    {
        double error = finishDegree - drivebase.getHeading();
        double speed = (KP * error) + Math.copySign(KF, error);
        drivebase.runMotor(speed, -speed);
    }

    @Override
    public boolean isFinished()
    {
        if(degree > 0)
        {
            return drivebase.getHeading() > finishDegree;
        }
        else
        {
            return drivebase.getHeading() < finishDegree;
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        drivebase.runMotor(0, 0);
        System.out.println("ending, final degree: " + drivebase.getHeading());
    }
}