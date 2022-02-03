package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.drivebases.Drivebase4Motor;


public class RotateCommand extends CommandBase
{
    private Drivebase drivebase;
    private double speed;
    private double degree;
    private double startDegreeRight;
    private double startDegreeLeft;

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
        startDegreeLeft = drivebase.getPosLeft();
        startDegreeRight = drivebase.getPosRight();

        if(degree > 0)
        {
            drivebase.runMotor(speed, -speed);
        }
        else
        {
            drivebase.runMotor(-speed, speed);
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
            return drivebase.getPosLeft() > (degree/360)*7.00313363+startDegreeLeft;
        }
        else
        {
            return drivebase.getPosRight() > (degree/360)*7.00313363+startDegreeRight;
        }
    }

    @Override
    public void end(boolean interrupted)
        {

        }
}
