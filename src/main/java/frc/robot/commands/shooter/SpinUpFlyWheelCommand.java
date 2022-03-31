package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;


public class SpinUpFlyWheelCommand extends CommandBase
{
    private Double setpoint;
    private int onTargetCount;
    private int onTargetThreshold = 3;
    boolean isAuto = false;
    public SpinUpFlyWheelCommand(Shooter s, Double speed)
    {
        addRequirements();
        shooter = s;
        setpoint = speed;
        isAuto = true;
    }

    public SpinUpFlyWheelCommand(Shooter s)
    {
        addRequirements();
        shooter = s;
    }

    Shooter shooter;
    @Override
    public void initialize()
    {
        //todo check this for teleop
        if(!isAuto || setpoint == null)
        {
            setpoint = shooter.getTarget();
            System.out.println("resetting shootwhenready setpoint to " + setpoint);
        }

        shooter.setFlywheel(setpoint);
    }

    @Override
    public void execute()
    {
        SmartDashboard.putNumber("Flywheel speed", shooter.getFlyWheelSpeed());
    }

    @Override
    public boolean isFinished()
    {
        if(Math.abs(shooter.getFlyWheelSpeed()-setpoint) < 85)
        {
            onTargetCount++;
        }
        else
        {
            onTargetCount = 0;
        }
        return onTargetCount >= onTargetThreshold;
    }

    @Override
    public void end(boolean interrupted)
    {
        if (interrupted)
        {
            shooter.setFlywheel(0);
        }
    }
}
