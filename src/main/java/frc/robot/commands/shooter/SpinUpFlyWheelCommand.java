package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;


public class SpinUpFlyWheelCommand extends CommandBase
{
    private Double setpoint;
    private int onTargetCount;
    private int onTargetThreshold = 10;
    boolean isAuto = false;
    private double currentSpeed;
    public SpinUpFlyWheelCommand(Shooter s, Double speed)
    {
        addRequirements();
        shooter = s;
        setpoint = speed;
        isAuto = true;
        currentSpeed = 0;
    }

    public SpinUpFlyWheelCommand(Shooter s)
    {
        addRequirements();
        shooter = s;
        currentSpeed = 0;
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
        SmartDashboard.putNumber("Flywheel speed", currentSpeed);
    }

    @Override
    public boolean isFinished()
    {
        currentSpeed = shooter.getFlyWheelSpeed();
        if(Math.abs(currentSpeed-setpoint) < 120)
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
