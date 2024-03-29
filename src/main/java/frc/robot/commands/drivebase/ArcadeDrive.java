package frc.robot.commands.drivebase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.services.Oi;
import frc.robot.subsystems.Drivebase;


public class ArcadeDrive extends CommandBase
{
    private double maximumEncoderSpeed = 20000;
    private double KP = 0.05/maximumEncoderSpeed;
    private double KF = 1./maximumEncoderSpeed;
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
        double turn = Math.copySign(Math.pow(Math.abs(oi.getRightX()), 1.5), oi.getRightX());
        double throttle = Math.copySign(Math.pow(Math.abs(-oi.getLeftY()), 1.5), -oi.getLeftY());
        SmartDashboard.putNumber("X", turn);
        SmartDashboard.putNumber("Y", throttle);
        double outputLeft = Math.max(Math.min((turn + throttle), 1), -1);
        double outputRight = Math.max(Math.min((-turn + throttle), 1), -1);
        double targetLeft = maximumEncoderSpeed * outputLeft;
        double targetRight = maximumEncoderSpeed * outputRight;
        double errorLeft = targetLeft - drivebase.getSpeedLeft();
        double errorRight = targetRight - drivebase.getSpeedRight();
        SmartDashboard.putNumber("errorLeft", errorLeft);
        SmartDashboard.putNumber("errorRight", errorRight);
        outputLeft = KP * errorLeft + KF * targetLeft;
        outputRight = KP * errorRight + KF * targetRight;
        if(oi.isToggleClimberPressed() || oi.isLeftStickTriggerPressed())
        {
            System.out.println("driving slow");
            drivebase.runMotor(outputLeft/2, outputRight/2);
        }
        else
        {
            drivebase.runMotor(outputLeft, outputRight);
        }
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
