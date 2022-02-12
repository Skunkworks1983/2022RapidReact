package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.constants.Constants;

public class DropCollector extends Collector
{
    Servo collectorRelease = new Servo(Constants.MotorPorts.collectorServo.COLLECTOR_SERVO_DEVICE_NUMBER);
    public void dropCollector(boolean open) //todo change name
    {
        if (open)
        {
            collectorRelease.setAngle(Constants.MotorPorts.collectorServo.COLLECTOR_SERVO_OPENED_ANGLE);
        }
        else
        {
            collectorRelease.setAngle(Constants.MotorPorts.collectorServo.COLLECTOR_SERVO_CLOSED_ANGLE);
        }
    }
}
