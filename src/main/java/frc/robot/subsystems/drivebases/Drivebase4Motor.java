package frc.robot.subsystems.drivebases;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;


public class Drivebase4Motor extends Drivebase
{
    TalonSRX leftMotor1 = new TalonSRX(Constants.MotorPorts.FourMotors.LEFT_MOTOR_1_DEVICE_NUMBER);
    TalonSRX leftMotor2 = new TalonSRX(Constants.MotorPorts.FourMotors.LEFT_MOTOR_2_DEVICE_NUMBER);
    TalonSRX rightMotor1 = new TalonSRX(Constants.MotorPorts.FourMotors.RIGHT_MOTOR_1_DEVICE_NUMBER);
    TalonSRX rightMotor2 = new TalonSRX(Constants.MotorPorts.FourMotors.RIGHT_MOTOR_2_DEVICE_NUMBER);

    Encoder leftEncoder = new Encoder(Constants.EncoderPorts.FourMotorTalonSRX.LEFT_A_PORT, Constants.EncoderPorts.FourMotorTalonSRX.LEFT_B_PORT);
    Encoder rightEncoder = new Encoder(Constants.EncoderPorts.FourMotorTalonSRX.RIGHT_A_PORT, Constants.EncoderPorts.FourMotorTalonSRX.RIGHT_B_PORT);

    AHRS gyro = new AHRS(I2C.Port.kOnboard);

    private final double distancePerMotorRotation = 0.006135923151543;

    @Override
    public void runMotor(double turnSpeedLeft, double turnSpeedRight)
    {
        leftMotor1.set(TalonSRXControlMode.PercentOutput, turnSpeedLeft);
        leftMotor2.set(TalonSRXControlMode.PercentOutput, turnSpeedLeft);
        rightMotor1.set(TalonSRXControlMode.PercentOutput, -turnSpeedRight);
        rightMotor2.set(TalonSRXControlMode.PercentOutput, -turnSpeedRight);
        //System.out.println("going at: "+turnSpeedLeft+" Left, going at: "+turnSpeedRight+" right, degree: "+getHeading());
    }

    public double getPosLeft()
    {
        return (leftEncoder.getDistance());
    }

    public double getPosRight()
    {
        return (-rightEncoder.getDistance());
    }

    public double getHeading()
    {
        return gyro.getAngle();
    }

    public boolean isCalibrating()
    {
        return gyro.isCalibrating();
    }

    public double getTicksLeft(){return 0;}

    public Drivebase4Motor()
    {
        leftEncoder.setDistancePerPulse(distancePerMotorRotation);
        rightEncoder.setDistancePerPulse(distancePerMotorRotation);
        leftMotor1.setNeutralMode(NeutralMode.Brake);
        leftMotor2.setNeutralMode(NeutralMode.Brake);
        rightMotor1.setNeutralMode(NeutralMode.Brake);
        rightMotor2.setNeutralMode(NeutralMode.Brake);
    }

    public void turnOffBrakes()
    {
        leftMotor1.setNeutralMode(NeutralMode.Coast);
        leftMotor2.setNeutralMode(NeutralMode.Coast);
        rightMotor1.setNeutralMode(NeutralMode.Coast);
        rightMotor2.setNeutralMode(NeutralMode.Coast);
    }
}