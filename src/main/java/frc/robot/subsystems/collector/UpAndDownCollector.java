package frc.robot.subsystems.collector;

import edu.wpi.first.wpilibj.Relay;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;

public class UpAndDownCollector extends Collector
{
    Relay relayUpAndDown = new Relay(Constants.MotorPorts.CollectorRelay.COLLECTOR_RELAY_DEVICE_NUMBER);
    @Override
    public void setCollectorAngle(boolean moveDownward)
    {
        if (moveDownward)
        {
            relayUpAndDown.set(Relay.Value.kForward);
        }
        else
        {
            relayUpAndDown.set(Relay.Value.kReverse);
        }
    }
}
