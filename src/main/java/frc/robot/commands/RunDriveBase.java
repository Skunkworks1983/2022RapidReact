package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


public class RunDriveBase extends CommandBase
{
    private Drivebase drivebase;
    private Double leftSpeed;
    private Double rightSpeed;
    // Runs the Drivebase Motors at specified percent power
    public RunDriveBase(Double leftSpeed, Double rightSpeed, Drivebase drivebase)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(drivebase);
        this.drivebase = drivebase;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }
    @Override
    public void initialize()
    {
        drivebase.runMotor(leftSpeed, rightSpeed);
    }

    @Override
    public void execute()
    {

    }

    @Override
    public boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {
        drivebase.runMotor(0, 0);
        System.out.println("Run Motors Ended");
    }
}
