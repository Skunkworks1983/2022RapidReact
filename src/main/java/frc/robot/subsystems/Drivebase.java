package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;


public abstract class Drivebase extends SubsystemBase
{
    public Drivebase()
    {

    }
    public abstract void runMotor(double turnSpeedLeft, double turnSpeedRight);

    public abstract double getPosLeft();

    public abstract double getPosRight();
}