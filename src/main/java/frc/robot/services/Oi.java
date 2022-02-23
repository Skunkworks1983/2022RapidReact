package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MoveCollectorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LoadFirstBallCommand;
import frc.robot.commands.LoadSecondBallCommand;
import frc.robot.commands.RunFlyWheelCommand;
import frc.robot.commands.RunIndexerCommand;
import frc.robot.commands.RunLiftBallCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.Collector;

public class Oi
{
    Joystick leftStick;
    Joystick rightStick;
    JoystickButton highShooterButton;
    JoystickButton lowShooterButton;
    JoystickButton liftBallButton;
    JoystickButton indexerButton;
    JoystickButton runBothLifts;
    JoystickButton intakeButton;
    JoystickButton reverseIntakeButton;
    JoystickButton collectorUpwardButton;
    JoystickButton collectorDownwardButton;
    JoystickButton dropOnButton;
    JoystickButton dropOffButton;
    JoystickButton upButton;
    JoystickButton downButton;
    JoystickButton loadFirstBallButton;
    JoystickButton loadSecondBallButton;

    public Oi(Collector collector, Drivebase drivebase, Shooter shooter)
    {

        leftStick = new Joystick(Constants.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.RIGHT_JOY_STICK_PORT);

        highShooterButton = new JoystickButton(leftStick, Constants.FLY_WHEEL_BUTTONS);
        lowShooterButton = new JoystickButton(rightStick, Constants.FLY_WHEEL_BUTTONS);
        liftBallButton = new JoystickButton(rightStick, Constants.LIFT_BALL_BUTTON);
        loadFirstBallButton = new JoystickButton(rightStick, Constants.LOAD_FIRST_BALL_BUTTON);
        loadSecondBallButton = new JoystickButton(rightStick, Constants.LOAD_SECOND_BALL_BUTTON);
        indexerButton = new JoystickButton(leftStick, Constants.INDEXER_BUTTON);
        runBothLifts = new JoystickButton(rightStick, Constants.RUN_BOTH_LIFTS);

        highShooterButton.whenHeld(new RunFlyWheelCommand(shooter, 19000.0)); // shoot high
        lowShooterButton.whenHeld(new RunFlyWheelCommand(shooter, 9500.0)); // shoot low
        indexerButton.whenHeld(new RunIndexerCommand(shooter));
        liftBallButton.whenHeld(new RunLiftBallCommand(shooter));

        intakeButton = new JoystickButton(leftStick, Constants.INTAKE_BUTTON);
        reverseIntakeButton = new JoystickButton(rightStick, Constants.REVERSE_INTAKE_BUTTON);
        collectorUpwardButton = new JoystickButton(leftStick, Constants.UPWARD_COLLECTOR_BUTTON);
        collectorDownwardButton = new JoystickButton(rightStick, Constants.DOWNWARD_COLLECTOR_BUTTON);

        intakeButton.whenHeld(new IntakeCommand(collector, .5));
        reverseIntakeButton.whenHeld(new IntakeCommand(collector, -.5));

        collectorUpwardButton.whenPressed(new MoveCollectorCommand(collector, false));
        collectorDownwardButton.whenPressed(new MoveCollectorCommand(collector, true));

    }

    public double getLeftY()
    {
        return leftStick.getY();
    }

    public double getRightY()
    {
        return rightStick.getY();
    }

    public double getLeftX()
    {
        return leftStick.getX();
    }

    public double getRight()
    {
        return rightStick.getX();
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

    public JoystickButton getRunBothLifts()
    {
        return runBothLifts;
    }
}

