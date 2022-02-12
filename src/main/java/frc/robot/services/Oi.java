package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DropCollectorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.UpAndDownCollectorCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.DropCollector;
import frc.robot.subsystems.UpAndDownCollector;

public class Oi
{
    Joystick leftStick;
    Joystick rightStick;
    JoystickButton intakeButton;
    JoystickButton reverseIntakeButton;
    JoystickButton dropOnButton;
    JoystickButton dropOffButton;
    JoystickButton upButton;
    JoystickButton downButton;

    public Oi(Collector subsystem, DropCollector dropSubsystem, UpAndDownCollector upAndDownSubsystems)
    {
        leftStick = new Joystick(Constants.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.RIGHT_JOY_STICK_PORT);
        intakeButton = new JoystickButton(leftStick, Constants.intakeButton);
        reverseIntakeButton = new JoystickButton(rightStick, Constants.reverseIntakeButton);
        dropOnButton = new JoystickButton(leftStick, Constants.dropOnButton);
        dropOffButton = new JoystickButton(rightStick, Constants.dropOffButton);
        upButton = new JoystickButton(leftStick, Constants.upButton);
        downButton = new JoystickButton(rightStick, Constants.downButton);
        intakeButton.whenHeld(new IntakeCommand(subsystem, .5));
        reverseIntakeButton.whenHeld(new IntakeCommand(subsystem, -.5));
        dropOnButton.whenPressed(new DropCollectorCommand(dropSubsystem, true));
        dropOffButton.whenPressed(new DropCollectorCommand(dropSubsystem, false));
        upButton.whenPressed(new UpAndDownCollectorCommand(upAndDownSubsystems, true));
        downButton.whenPressed(new UpAndDownCollectorCommand(upAndDownSubsystems, false));
    }

    public double getLeftY()
    {
        return leftStick.getY();
    }
    public double getRightY()
    {
        return rightStick.getY();
    }
}