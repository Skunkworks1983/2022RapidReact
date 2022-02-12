package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import frc.robot.constants.Constants;

public class UpAndDownCollector extends Collector
{
    Relay relayUpAndDown = new Relay(Constants.MotorPorts.collectorRelay.COLLECTOR_RELAY_DEVICE_NUMBER);
    public void raiseCollector(boolean raise)
    {
        if (raise)
        {
            relayUpAndDown.set(Relay.Value.kReverse);
        }
        else
        {
            relayUpAndDown.set(Relay.Value.kForward);
        }
    } //Ctrl + click
}
