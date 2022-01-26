package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.constants.Constants;

public class DropCollector extends Collector
{
    public void dropCollector(boolean opened) //todo change name
    {
        Servo collectorRelease = new Servo(Constants.MotorPorts.collectorServo.collectorServoDeviceNumber);
        if (opened)
        {
            collectorRelease.setAngle(Constants.MotorPorts.collectorServo.collectorServoOpenedAngle);
        }
        else
        {
            collectorRelease.setAngle(Constants.MotorPorts.collectorServo.collectorServoClosedAngle);
        }
    }
}
