// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.constants.Constants;

import static frc.robot.constants.Constants.MotorPorts.Shooter.*;

public class Shooter extends SubsystemBase
{
    private TalonFX flywheel = new TalonFX(FLYWHEEL_DEVICE_NUMBER);
    private TalonSRX liftBall = new TalonSRX(LIFT_BALL_DEVICE_NUMBER);
    private TalonSRX indexer = new TalonSRX(INDEXER_DEVICE_NUMBER);
    private DigitalInput intakeSensor = new DigitalInput(Constants.EncoderPorts.Shooter.INTAKE_SENSOR_PORT);
    private DigitalInput beforeFlyWheel = new DigitalInput(Constants.EncoderPorts.Shooter.BEFORE_FLYWHEEL_SENSOR_PORT);

    private double target;

    public void setFlywheel(double speed)
    {
        flywheel.set(TalonFXControlMode.Velocity, -speed);
        if(speed > 0)
        {
            setTarget(speed);
        }
    }

    public void setLiftBall(double speed)
    {
        liftBall.set(TalonSRXControlMode.PercentOutput, speed);
    }

    public void setIndexer(double speed)
    {
        indexer.set(TalonSRXControlMode.PercentOutput, speed);
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
        return -flywheel.getSelectedSensorVelocity();
    }

    public boolean isBallAtIntake(){return !intakeSensor.get();}

    public boolean isBallBeforeFlyWheel(){return !beforeFlyWheel.get();}

    public void setTarget(double target)
    {
        System.out.println("shooter updating target to " + target);
        this.target = target;
    }
    public double getTarget()
    {
     return target;
    }

    public void initializeFlywheel()
    {
        flywheel.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, 30, 30);
        flywheel.config_kF(0, Constants.Shooter.FLY_WHEEL_KF);
        flywheel.config_kP(0, Constants.Shooter.FLY_WHEEL_KP);
        flywheel.selectProfileSlot(0, 0);
        flywheel.configClosedloopRamp(0.5);
        flywheel.setNeutralMode(NeutralMode.Coast);
    }

    /** Creates a new Shooter. */
    public Shooter()
    {
        initializeFlywheel();
        liftBall.setNeutralMode(NeutralMode.Brake);
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
