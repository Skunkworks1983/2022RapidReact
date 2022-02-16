package frc.robot.subsystems.collector;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;

public class DropCollector extends Collector
{
    Servo collectorRelease = new Servo(Constants.MotorPorts.CollectorServo.COLLECTOR_SERVO_DEVICE_NUMBER);
    public void setCollectorAngled(boolean moveDownward)
    {
        if (moveDownward)
        {
            collectorRelease.setAngle(Constants.MotorPorts.CollectorServo.COLLECTOR_SERVO_OPENED_ANGLE);
        }
        else
        {
            collectorRelease.setAngle(Constants.MotorPorts.CollectorServo.COLLECTOR_SERVO_CLOSED_ANGLE);
        }
    }
}
