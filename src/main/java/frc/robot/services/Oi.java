package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.MoveCollectorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LoadBallsCommandGroup;
import frc.robot.commands.ShootAllBallsHighCommand;
import frc.robot.commands.ShootAllBallsLowCommand;
import frc.robot.commands.SpinUpAndShootAllBallsHighCommandGroup;
import frc.robot.commands.SpinUpAndShootAllBallsLowCommandGroup;
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
    JoystickButton loadSecondBallButton;
    JoystickButton shootAllBallsHigh;
    JoystickButton shootAllBallsLow;
    JoystickButton loadBallsButton;

    public Oi(Collector collector, Drivebase drivebase, Shooter shooter)
    {

        leftStick = new Joystick(Constants.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.RIGHT_JOY_STICK_PORT);
        buttonStick = new Joystick(Constants.BUTTON_STICK_PORT);

        highShooterButton = new JoystickButton(buttonStick, Constants.HIGH_SHOOTER_BUTTON);
        lowShooterButton = new JoystickButton(buttonStick, Constants.LOW_SHOOTER_BUTTON);
        liftBallButton = new JoystickButton(buttonStick, Constants.LIFT_BALL_BUTTON);
        loadFirstBallButton = new JoystickButton(buttonStick, Constants.LOAD_FIRST_BALL_BUTTON);
        //loadSecondBallButton = new JoystickButton(buttonStick, Constants.LOAD_SECOND_BALL_BUTTON);
        indexerButton = new JoystickButton(buttonStick, Constants.INDEXER_BUTTON);
        shootAllBallsHigh = new JoystickButton(buttonStick, Constants.SHOOT_ALL_BALLS_HIGH_BUTTON);
        shootAllBallsLow = new JoystickButton(buttonStick, Constants.SHOOT_ALL_BALLS_LOW_BUTTON);
        loadBallsButton = new JoystickButton(buttonStick, Constants.LOAD_BALLS_BUTTON);
        //runBothLifts = new JoystickButton(rightStick, Constants.RUN_BOTH_LIFTS);

        intakeButton = new JoystickButton(buttonStick, Constants.INTAKE_BUTTON);
        reverseIntakeButton = new JoystickButton(buttonStick, Constants.REVERSE_INTAKE_BUTTON);
        dropOnButton = new JoystickButton(leftStick, Constants.DROP_ON_BUTTON);
        dropOffButton = new JoystickButton(rightStick, Constants.DROP_OFF_BUTTON);
        upButton = new JoystickButton(leftStick, Constants.UP_BUTTON);
        downButton = new JoystickButton(rightStick, Constants.DOWN_BUTTON);

        highShooterButton.whenHeld(new RunFlyWheelCommand(shooter, Constants.HIGH_GOAL_SPEED)); // shoot high
        lowShooterButton.whenHeld(new RunFlyWheelCommand(shooter, Constants.LOW_GOAL_SPEED)); // shoot low
        liftBallButton.whenHeld(new RunLiftBallCommand(shooter));
        loadFirstBallButton.whenHeld(new LoadFirstBallCommand(shooter));
        //loadSecondBallButton.whenHeld(new LoadSecondBallCommand(shooter));
        indexerButton.whenHeld(new RunIndexerCommand(shooter));
        liftBallButton.whenHeld(new RunLiftBallCommand(shooter));

        intakeButton = new JoystickButton(leftStick, Constants.INTAKE_BUTTON);
        reverseIntakeButton = new JoystickButton(rightStick, Constants.REVERSE_INTAKE_BUTTON);
        collectorUpwardButton = new JoystickButton(leftStick, Constants.UPWARD_COLLECTOR_BUTTON);
        collectorDownwardButton = new JoystickButton(rightStick, Constants.DOWNWARD_COLLECTOR_BUTTON);
        shootAllBallsHigh.whenHeld(new SpinUpAndShootAllBallsHighCommandGroup(shooter));
        shootAllBallsLow.whenHeld(new SpinUpAndShootAllBallsLowCommandGroup(shooter));
        loadBallsButton.whenHeld(new LoadBallsCommandGroup(shooter));

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

