package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.collector.CollectorEncoderResetCommand;
import frc.robot.commands.collector.IntakeCommand;
import frc.robot.commands.collector.ManualIntakeCommand;
import frc.robot.commands.collector.ManualMoveCollectorCommand;
import frc.robot.commands.collector.MoveCollectorMotorControllerCommand;
import frc.robot.commands.shooter.IndexerManualShootCommand;
import frc.robot.commands.shooter.IndexerOutputCommand;
import frc.robot.commands.shooter.LoadBothBallsCommandGroup;
import frc.robot.commands.shooter.SpinUpFlyWheelHighCommand;
import frc.robot.commands.shooter.SpinUpFlyWheelLowCommand;
import frc.robot.commands.collector.MoveCollectorCommand;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;
import frc.robot.subsystems.collector.Collector;

public class Oi
{
    Joystick leftStick;
    Joystick rightStick;
    Joystick buttonStick;
    JoystickButton collectorUpwardButton;
    JoystickButton collectorDownwardButton;
    JoystickButton loadBallsButton;
    JoystickButton manualMoveCollectorUp;
    JoystickButton manualMoveCollectorDown;
    JoystickButton indexerOutputButton;
    JoystickButton spinUpFlyWheelLowButton;
    JoystickButton spinUpFlyWheelHighButton;
    JoystickButton indexerManualShootButton;
    JoystickButton collectorIn;
    JoystickButton collectorOut;
    JoystickButton indexerShootWhenReady;
    JoystickButton enableManualControls;
    JoystickButton collectorEncoderReset;

    public Oi(Collector collector, Drivebase drivebase, Shooter shooter)
    {

        leftStick = new Joystick(Constants.JoystickPorts.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.JoystickPorts.RIGHT_JOY_STICK_PORT);
        buttonStick = new Joystick(Constants.JoystickPorts.BUTTON_STICK_PORT);

        //button sticks
        loadBallsButton = new JoystickButton(buttonStick, Constants.OIButtons.LOAD_BALLS_BUTTON);
        manualMoveCollectorUp = new JoystickButton(buttonStick, Constants.OIButtons.MANUAL_UPWARD_COLLECTOR_BUTTON);
        manualMoveCollectorDown = new JoystickButton(buttonStick, Constants.OIButtons.MANUAL_DOWNWARD_COLLECTOR_BUTTON);
        indexerOutputButton = new JoystickButton(buttonStick, Constants.OIButtons.INDEXER_OUTPUT_BUTTON);
        spinUpFlyWheelLowButton = new JoystickButton(buttonStick, Constants.OIButtons.SPIN_UP_FLYWHEEL_LOW);
        spinUpFlyWheelHighButton = new JoystickButton(buttonStick, Constants.OIButtons.SPIN_UP_FLYWHEEL_HIGH);
        indexerManualShootButton = new JoystickButton(buttonStick, Constants.OIButtons.INDEXER_MANUAL_SHOOT);
        collectorUpwardButton = new JoystickButton(buttonStick, Constants.OIButtons.UPWARD_COLLECTOR_BUTTON);
        collectorDownwardButton = new JoystickButton(buttonStick, Constants.OIButtons.DOWNWARD_COLLECTOR_BUTTON);
        collectorIn = new JoystickButton(buttonStick, Constants.OIButtons.COLLECTOR_IN);
        collectorOut = new JoystickButton(buttonStick, Constants.OIButtons.COLLECTOR_OUT);
        indexerShootWhenReady = new JoystickButton(buttonStick, Constants.OIButtons.INDEXER_SHOOT_WHEN_READY);
        enableManualControls = new JoystickButton(buttonStick, Constants.OIButtons.ENABLE_MANUAL_CONTROLS);
        collectorEncoderReset = new JoystickButton(buttonStick, Constants.OIButtons.COLLECTOR_ENCODER_RESET_BUTTON);

        //when held
        loadBallsButton.whenHeld(new LoadBothBallsCommandGroup(shooter));
        manualMoveCollectorDown.whenHeld(new ManualMoveCollectorCommand(0.25, collector));
        manualMoveCollectorUp.whenHeld(new ManualMoveCollectorCommand(-0.25, collector));
        indexerOutputButton.whenHeld(new IndexerOutputCommand(shooter));
        spinUpFlyWheelLowButton.whenHeld(new SpinUpFlyWheelLowCommand(shooter));
        spinUpFlyWheelHighButton.whenHeld(new SpinUpFlyWheelHighCommand(shooter));
        indexerManualShootButton.whenHeld(new IndexerManualShootCommand(shooter));
        collectorIn.whenHeld(new ManualIntakeCommand(collector, 0.4));
        collectorOut.whenHeld(new ManualIntakeCommand(collector, -0.4));

        //collector when pressed
        collectorEncoderReset.whenPressed(new CollectorEncoderResetCommand(collector));
        collectorUpwardButton.whenPressed(new MoveCollectorMotorControllerCommand(collector, false));
        collectorDownwardButton.whenPressed(new MoveCollectorMotorControllerCommand(collector, true));
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

