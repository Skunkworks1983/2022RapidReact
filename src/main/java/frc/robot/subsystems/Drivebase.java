package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public abstract class Drivebase extends SubsystemBase
{
    public Drivebase()
    {

    }
    public abstract void runMotor(double turnSpeedLeft, double turnSpeedRight);
}