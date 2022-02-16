// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import static frc.robot.constants.Constants.MotorPorts.Shooter.*;

public class Shooter extends SubsystemBase
{
    private TalonFX flyWheel = new TalonFX(FLY_WHEEL_DEVICE_NUMBER);
    private TalonSRX liftBall = new TalonSRX(LIFT_BALL_DEVICE_NUMBER);
    private TalonSRX indexer = new TalonSRX(INDEXER_DEVICE_NUMBER);
    private DigitalInput intakeSensor = new DigitalInput(0);
    private DigitalInput beforeFlyWheel = new DigitalInput(1);

    public void setFlyWheel(double speed)
    {
        flyWheel.set(TalonFXControlMode.Velocity, -speed);
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

    public boolean isBallAtIntake(){return !intakeSensor.get();}

    public boolean isBallBeforeFlyWheel(){return !beforeFlyWheel.get();}

    public void setFlyWheelControlConstants(double f, double p)
    {
        flyWheel.config_kF(0, f);
        flyWheel.config_kP(0, p);
        flyWheel.selectProfileSlot(0, 0);
        flyWheel.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor,0,0);
        flyWheel.configClosedLoopPeakOutput(0,1,0);
        flyWheel.setSensorPhase(false);
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
