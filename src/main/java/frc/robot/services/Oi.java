package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.constants.Constants;

public class Oi
{
    Joystick leftStick;
    Joystick rightStick;
    JoystickButton shooterButton;
    JoystickButton liftBallButton;
    JoystickButton indexerButton;
    JoystickButton runBothLifts;

    public Oi()
    {
        leftStick = new Joystick(Constants.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.RIGHT_JOY_STICK_PORT);
        shooterButton = new JoystickButton(leftStick, 1);
        liftBallButton = new JoystickButton(rightStick, Constants.Shooter_Button);
        indexerButton = new JoystickButton(leftStick, 2);
        runBothLifts = new JoystickButton(rightStick, Constants.Run_Both_Lifts);
    }

    public double getLeftY()
    {
        return leftStick.getY();
    }
    public double getRightY()
    {
        return rightStick.getY();
    }

    public JoystickButton getShooterButton()
    {
        return shooterButton;
    }

    public JoystickButton getLiftBallButton()
    {
        return liftBallButton;
    }

    public JoystickButton getIndexerButton()
    {
        return indexerButton;
    }

    public JoystickButton getRunBothLifts(){return runBothLifts;}
}

