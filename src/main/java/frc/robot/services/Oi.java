package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.collector.ManualCollectorCommand;
import frc.robot.commands.collector.MoveCollectorCommand;
import frc.robot.commands.collector.ResetCollectorEncoderCommand;
import frc.robot.commands.shooter.LoadBothBallsCommandGroup;
import frc.robot.commands.shooter.SpinUpFlyWheelAndShootAllBallsHighCommandGroup;
import frc.robot.commands.shooter.SpinUpFlyWheelAndShootAllBallsLowCommandGroup;
import frc.robot.commands.shooter.LoadFirstBallCommand;
import frc.robot.commands.shooter.RunFlyWheelCommand;
import frc.robot.commands.shooter.RunIndexerCommand;
import frc.robot.commands.shooter.RunLiftBallCommand;
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
    JoystickButton resetCollectorEncoderButton;
    JoystickButton collectorUpwardButton;
    JoystickButton collectorDownwardButton;
    JoystickButton collectorManueleUpwardButton;
    JoystickButton collectorManueleDownwardButton;
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

        //collector when held
        collectorUpwardButton = new JoystickButton(buttonStick, Constants.UPWARD_COLLECTOR_BUTTON);
        collectorDownwardButton = new JoystickButton(buttonStick, Constants.DOWNWARD_COLLECTOR_BUTTON);
        collectorUpwardButton.whenPressed(new MoveCollectorCommand(collector, false));
        collectorDownwardButton.whenPressed(new MoveCollectorCommand(collector, true));
        collectorManueleUpwardButton = new JoystickButton(buttonStick, Constants.UPWARD_MANUELE_COLLECTOR_BUTTON);
        collectorManueleDownwardButton = new JoystickButton(buttonStick, Constants.DOWNWARD_MANUELE_COLLECTOR_BUTTON);
        collectorManueleUpwardButton.whenPressed(new ManualCollectorCommand(collector, false));
        collectorManueleDownwardButton.whenPressed(new ManualCollectorCommand(collector, true));
        resetCollectorEncoderButton = new JoystickButton(buttonStick, Constants.RESET_COLLECTOR_ENCODER_BUTTON);
        resetCollectorEncoderButton.whenHeld(new ResetCollectorEncoderCommand(collector));

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

