// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.constants.Constants.MotorPorts.shooter.*;

public class Shooter extends SubsystemBase
{
    private TalonSRX flyWheel = new TalonSRX(flyWheelDeviceNumber);
    private TalonSRX liftBall1 = new TalonSRX(liftBall1DeviceNumber);
    private TalonSRX liftBall2 = new TalonSRX(liftBall2DeviceNumber);

    public void setFlyWheel(double speed)
    {
        flyWheel.set(TalonSRXControlMode.PercentOutput, -speed);
    }

    public void setLiftBall1(double speed)
    {
        liftBall1.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public void setLiftBall2(double speed)
    {
        liftBall2.set(TalonSRXControlMode.PercentOutput, -speed);
    }

    public double getFlywheelSpeed()
        {
           return flyWheel.getSelectedSensorVelocity();
        }

    /** Creates a new ExampleSubsystem. */
    public Shooter() {}

    @Override
    public void periodic()
    {
        // This method will be called once per scheduler run
    }
    
    
    @Override
    public void simulationPeriodic()
    {
        // This method will be called once per scheduler run during simulation
    }
}
