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
        return Math.abs(drivebase.getHeading() - finishDegree)< 0.5;
    }

    @Override
    public void end(boolean interrupted)
    {
        drivebase.runMotor(0, 0);
        System.out.println("ending, final degree: " + drivebase.getHeading());
    }
}