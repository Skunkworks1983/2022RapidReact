package frc.robot.subsystems.climber;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.constants.Constants;

public class Climber
{
    DoubleSolenoid rightSolenoid;

    public Climber()
    {
        rightSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Climber.RIGHT_SOLENOID_UP_PORT, Constants.Climber.RIGHT_SOLENOID_DOWN_PORT);
    }

    public void setArm(boolean up)
    {
        rightSolenoid.set(up ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

}