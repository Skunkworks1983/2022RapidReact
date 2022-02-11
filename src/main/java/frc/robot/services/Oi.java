package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.RunFlyWheelCommand;
import frc.robot.commands.RunIndexerCommand;
import frc.robot.commands.RunLiftBallCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class Oi
{
    Joystick leftStick;
    Joystick rightStick;
    JoystickButton highShooterButton;
    JoystickButton lowShooterButton;
    JoystickButton liftBallButton;
    JoystickButton indexerButton;
    JoystickButton runBothLifts;

    public Oi(Drivebase d, Shooter s)
    {
        leftStick = new Joystick(Constants.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.RIGHT_JOY_STICK_PORT);
        highShooterButton = new JoystickButton(leftStick, Constants.FLY_WHEEL_BUTTONS);
        lowShooterButton = new JoystickButton(rightStick, Constants.FLY_WHEEL_BUTTONS);
        liftBallButton = new JoystickButton(rightStick, Constants.LIFT_BALL_BUTTON);
        indexerButton = new JoystickButton(leftStick, Constants.INDEXER_BUTTON);
        runBothLifts = new JoystickButton(rightStick, Constants.Run_Both_Lifts);
        highShooterButton.whenHeld(new RunFlyWheelCommand(s, 19000.0)); // shoot high
        lowShooterButton.whenHeld(new RunFlyWheelCommand(s, 9500.0)); // shoot low
        indexerButton.whenHeld(new RunIndexerCommand(s));
        liftBallButton.whenHeld(new RunLiftBallCommand(s));
    }

    public double getLeftY()
    {
        return leftStick.getY();
    }
    public double getRightY()
    {
        return rightStick.getY();
    }

    public JoystickButton getHighShooterButton()
    {
        return highShooterButton;
    }

    public JoystickButton getLowShooterButton()
    {
        return lowShooterButton;
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

