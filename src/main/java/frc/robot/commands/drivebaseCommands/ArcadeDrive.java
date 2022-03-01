package frc.robot.commands.drivebaseCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.services.Oi;
import frc.robot.subsystems.Drivebase;


public class ArcadeDrive extends CommandBase
{

    private final Drivebase drivebase;
    private final Oi oi;

    public ArcadeDrive(Drivebase drivebase, Oi oi)
    {
        this.drivebase = drivebase;
        this.oi = oi;
        addRequirements(drivebase);
    }

    @Override
    public void initialize()
    {

    }

    @Override
    public void execute()
    {
        double turn = oi.getLeftX();
        double throttle = -oi.getRightY();
        double outputLeft = Math.max(Math.min((turn + throttle), 1), -1);
        double outputRight = Math.max(Math.min((-turn + throttle), 1), -1);
        if(outputLeft > 0)
        {
            outputLeft = Math.pow(outputLeft, 2);
        }
        else
        {
            outputLeft = -Math.abs(Math.pow(outputLeft, 2));
        }
        if(outputRight > 0)
        {
            outputRight = Math.pow(outputRight, 2);
        }
        else
        {
            outputRight = -Math.abs(Math.pow(outputRight, 2));
        }
        drivebase.runMotor(outputLeft, outputRight);
    }

    @Override
    public boolean isFinished()
    {
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {

    }
}
