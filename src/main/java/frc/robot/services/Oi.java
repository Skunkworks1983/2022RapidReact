package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.constants.Constants;

public class Oi
{
    Joystick leftStick;
    Joystick rightStick;
    JoystickButton intakeButton;

    public Oi()
    {
        leftStick = new Joystick(Constants.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.RIGHT_JOY_STICK_PORT);
        intakeButton = new JoystickButton(leftStick, Constants.intakeButton);
    }

    public double getLeftY()
    {
        return leftStick.getY();
    }
    public double getRightY()
    {
        return rightStick.getY();
    }
    public JoystickButton getIntakeButton()
    {
        return intakeButton;
    }
}
