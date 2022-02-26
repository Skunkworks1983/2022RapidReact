package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MoveCollectorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LoadBothBallsCommandGroup;
import frc.robot.commands.SpinUpFlyWheelAndShootAllBallsHighCommandGroup;
import frc.robot.commands.SpinUpFlyWheelAndShootAllBallsLowCommandGroup;
import frc.robot.commands.LoadFirstBallCommand;
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
    Joystick buttonStick;
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
    JoystickButton loadBallsButton;
    JoystickButton shootAllBallsHigh;
    JoystickButton shootAllBallsLow;

    public Oi(Collector collector, Drivebase drivebase, Shooter shooter)
    {

        leftStick = new Joystick(Constants.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.RIGHT_JOY_STICK_PORT);
        buttonStick = new Joystick(Constants.BUTTON_STICK_PORT);

        //shooter button sticks
        highShooterButton = new JoystickButton(buttonStick, Constants.HIGH_SHOOTER_BUTTON);
        lowShooterButton = new JoystickButton(buttonStick, Constants.LOW_SHOOTER_BUTTON);
        liftBallButton = new JoystickButton(buttonStick, Constants.LIFT_BALL_BUTTON);
        loadFirstBallButton = new JoystickButton(buttonStick, Constants.LOAD_FIRST_BALL_BUTTON);
        indexerButton = new JoystickButton(buttonStick, Constants.INDEXER_BUTTON);
        shootAllBallsHigh = new JoystickButton(buttonStick, Constants.SHOOT_ALL_BALLS_HIGH_BUTTON);
        shootAllBallsLow = new JoystickButton(buttonStick, Constants.SHOOT_ALL_BALLS_LOW_BUTTON);
        loadBallsButton = new JoystickButton(buttonStick, Constants.LOAD_BALLS_BUTTON);

        //collecter button sticks
        intakeButton = new JoystickButton(buttonStick, Constants.INTAKE_BUTTON);
        reverseIntakeButton = new JoystickButton(buttonStick, Constants.REVERSE_INTAKE_BUTTON);
        //loadSecondBallButton = new JoystickButton(buttonStick, Constants.LOAD_SECOND_BALL_BUTTON);
        //runBothLifts = new JoystickButton(rightStick, Constants.RUN_BOTH_LIFTS);

        //collecter left sticks
        dropOnButton = new JoystickButton(leftStick, Constants.DROP_ON_BUTTON);
        dropOffButton = new JoystickButton(rightStick, Constants.DROP_OFF_BUTTON);
        upButton = new JoystickButton(leftStick, Constants.UP_BUTTON);

        //collecter right sticks
        downButton = new JoystickButton(rightStick, Constants.DOWN_BUTTON);
        dropOffButton = new JoystickButton(rightStick, Constants.DROP_OFF_BUTTON);

        //shooter when held
        highShooterButton.whenHeld(new RunFlyWheelCommand(shooter, Constants.HIGH_GOAL_SPEED)); // shoot high
        lowShooterButton.whenHeld(new RunFlyWheelCommand(shooter, Constants.LOW_GOAL_SPEED)); // shoot low
        liftBallButton.whenHeld(new RunLiftBallCommand(shooter));
        loadFirstBallButton.whenHeld(new LoadFirstBallCommand(shooter));
        //loadSecondBallButton.whenHeld(new LoadSecondBallCommand(shooter));
        indexerButton.whenHeld(new RunIndexerCommand(shooter));
        liftBallButton.whenHeld(new RunLiftBallCommand(shooter));
        shootAllBallsHigh.whenHeld(new SpinUpFlyWheelAndShootAllBallsHighCommandGroup(shooter));
        shootAllBallsLow.whenHeld(new SpinUpFlyWheelAndShootAllBallsLowCommandGroup(shooter));
        loadBallsButton.whenHeld(new LoadBothBallsCommandGroup(shooter));

        //collecter when held
        intakeButton = new JoystickButton(leftStick, Constants.INTAKE_BUTTON);
        reverseIntakeButton = new JoystickButton(rightStick, Constants.REVERSE_INTAKE_BUTTON);
        collectorUpwardButton = new JoystickButton(leftStick, Constants.UPWARD_COLLECTOR_BUTTON);
        collectorDownwardButton = new JoystickButton(rightStick, Constants.DOWNWARD_COLLECTOR_BUTTON);
        intakeButton.whenHeld(new IntakeCommand(collector, shooter, 0.5, false));
        reverseIntakeButton.whenHeld(new IntakeCommand(collector, shooter,-.5, false));
        collectorUpwardButton.whenPressed(new MoveCollectorCommand(collector, false, 1));
        collectorDownwardButton.whenPressed(new MoveCollectorCommand(collector, true, 1));

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

    public double getRightX()
    {
        return rightStick.getX();
    }
}

