package frc.robot.subsystems.climber;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.constants.Constants;

public class Climber
{
    DoubleSolenoid rightSolenoid;
    DoubleSolenoid leftSolenoid;

    public Climber()
    {
        rightSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Climber.RIGHT_SOLENOID_UP_PORT, Constants.Climber.RIGHT_SOLENOID_DOWN_PORT);
        leftSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Climber.LEFT_SOLENOID_UP_PORT, Constants.Climber.LEFT_SOLENOID_DOWN_PORT);
    }

    public void ToggleArm()
    {
            rightSolenoid.toggle();
            leftSolenoid.toggle();



    }

}