package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.drivebases.Drivebase4Motor;


public class RotateCommand extends CommandBase
{
    private Drivebase drivebase;
    private double speed;
    private double degree;
    private double startDegree;

    public RotateCommand(Drivebase drivebase, double speed, double degree)
    {
        addRequirements();
        this.drivebase = drivebase;
        this.degree = degree;
        this.speed = speed;
    }

    @Override
    public void initialize()
    {
        startDegree = drivebase.getHeading();

        System.out.println("turning to: "+(degree+startDegree));
        System.out.println("starting speed is: "+speed+", starting degree is: "+startDegree);
        if(degree > 0)
        {
            drivebase.runMotor(-speed, speed);
        }
        else
        {
            drivebase.runMotor(speed, -speed);
        }
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        if(degree > 0)
        {
            if (startDegree+degree > 360)
            {
                if(drivebase.getHeading() < startDegree)
                {
                    return startDegree + degree - 360 < drivebase.getHeading(); //here
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return startDegree + degree < drivebase.getHeading();
            }
        }
        else
        {
            if(startDegree+degree < 0)
            {
                return startDegree + degree + 360 > drivebase.getHeading();
            }
            else
            {
                return startDegree + degree > drivebase.getHeading();
            }
        }
    }

    @Override
    public void end(boolean interrupted)
        {
            drivebase.runMotor(0, 0);
            System.out.println("ending");
        }
}
