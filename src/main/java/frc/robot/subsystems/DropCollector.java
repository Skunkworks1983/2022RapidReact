package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.constants.Constants;

public class DropCollector extends Collector
{
    Servo collectorRelease = new Servo(Constants.MotorPorts.collectorServo.collectorServoDeviceNumber);
    public void dropCollector(boolean open) //todo change name
    {
        if (open)
        {
            collectorRelease.setAngle(Constants.MotorPorts.collectorServo.collectorServoOpenedAngle);
        }
        else
        {
            collectorRelease.setAngle(Constants.MotorPorts.collectorServo.collectorServoClosedAngle);
        }
    }
}
