// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.constants.Constants.MotorPorts.Shooter.*;

public class Shooter extends SubsystemBase
{
    private TalonSRX flyWheel = new TalonSRX(FLY_WHEEL_DEVICE_NUMBER);
    private TalonSRX liftBall = new TalonSRX(LIFT_BALL_DEVICE_NUMBER);
    private TalonSRX indexer = new TalonSRX(INDEXER_DEVICE_NUMBER);

    public void setFlyWheel(double speed)
    {
        flyWheel.set(TalonSRXControlMode.PercentOutput, -speed);
    }

    public void setLiftBall(double speed)
    {
        liftBall.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public void setIndexer(double speed)
    {
        indexer.set(TalonSRXControlMode.PercentOutput, -speed);
    }

    public  double getLiftBallSpeed()
    {
        return  liftBall.getSelectedSensorVelocity();
    }

    public double getIndexerSpeed()
    {
        return indexer.getSelectedSensorVelocity();
    }

    public double getFlyWheelSpeed()
    {
        return -flyWheel.getSelectedSensorVelocity();
    }

    /** Creates a new Shooter. */
    public Shooter()
    {

    }

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
