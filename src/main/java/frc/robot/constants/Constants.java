// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
    public class OIButtons
    {
        public static final int DOWNWARD_COLLECTOR_BUTTON = 2;
        public static final int INDEXER_MANUAL_SHOOT = 3;
        public static final int UPWARD_COLLECTOR_BUTTON = 4;
        public static final int ENABLE_MANUAL_CONTROLS = 5;
        public static final int MANUAL_UPWARD_COLLECTOR_BUTTON = 6;
        public static final int MANUAL_DOWNWARD_COLLECTOR_BUTTON = 7;
        public static final int SPIN_UP_FLYWHEEL_HIGH = 9;
        public static final int SPIN_UP_FLYWHEEL_LOW = 10;
        public static final int COLLECTOR_IN = 11;
        public static final int LOAD_BALLS_BUTTON = 12;
        public static final int INDEXER_SHOOT_WHEN_READY = 13;
        public static final int COLLECTOR_OUT = 14;
        public static final int INDEXER_OUTPUT_BUTTON = 15;
        public static final int COLLECTOR_ENCODER_RESET_BUTTON = 8;
    }

    public class JoystickPorts
    {

        public static final int LEFT_JOY_STICK_PORT = 0;
        public static final int RIGHT_JOY_STICK_PORT = 1;
        public static final int BUTTON_STICK_PORT = 2;
    }

    public class Collector
    {
        public static final int GEAR_RATIO = 64;
        public static final int THRESHOLD = 2;
        public static final double KP_VALUE = 1/90.;
    }

    public class Shooter
    {
        public static final double INDEXER_LOAD_SPEED = 0.4;
        public static final double LIFT_BALL_LOAD_SPEED = 0.5;
        public static final double FLY_WHEEL_KP = .08;
        public static final double FLY_WHEEL_KF = .0456;
        public static final double HIGH_GOAL_SPEED = 14300;
        public static final double LOW_GOAL_SPEED = 9550;
    }

    public class Drivebase
    {
        public static final double GEAR_RATIO = 10.71;
        public static final double WHEEL_DIAMETER = 0.5;
        public static final double DISTANCE_KP = 0.05;
        public static final double ROTATE_KP = 0.005;
        public static final double ANGLE_KP = 0.018;
        public static final double DRIVEBASE_KF = 0.2;
        public static final int THRESHOLD_ROTATE = 3;
        // Auto Left Constants
        public static final double AUTO_LEFT_DRIVE_AND_COLLECT_DISTANCE = 3.5;
        public static final double AUTO_LEFT_DRIVE_DISTANCE = -4.0;
        public static final int AUTO_LEFT_ROTATE = 153;
        public static final double AUTO_LEFT_TIMED_DRIVE_FORWARD_HOW_LONG_TO_RUN = 1.1;
        public static final double AUTO_LEFT_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE = 0.15;
        // Auto Center Constants
        public static final double AUTO_CENTER_DRIVE_DISTANCE_ONE = 2.0;
        public static final int AUTO_CENTER_ROTATE_ONE = -10;
        public static final double AUTO_CENTER_DRIVE_AND_COLLECT_DISTANCE = 3.0;
        public static final int AUTO_CENTER_ROTATE_TWO = -150;
        public static final double AUTO_CENTER_DRIVE_DISTANCE_TWO = 8.0;
        public static final int AUTO_CENTER_ROTATE_THREE = -65;
        public static final double AUTO_CENTER_TIMED_DRIVE_FORWARD_HOW_LONG_TO_RUN = 3.0;
        public static final double AUTO_CENTER_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE = 0.2;
        // Auto Right Constants
        public static final double AUTO_RIGHT_DRIVE_AND_COLLECT_DISTANCE = 3.0;
        public static final double AUTO_RIGHT_DRIVE_DISTANCE = -3;
        public static final int AUTO_RIGHT_ROTATE = -150;
        public static final double AUTO_RIGHT_TIMED_DRIVE_FORWARD_HOW_LONG_TO_RUN = 2.0;
        public static final double AUTO_RIGHT_TIMED_DRIVE_FORWARD_HOW_FAST_TO_DRIVE = 0.2;
        // Exit Tarmac Constants
        public static final int EXIT_TARMAC_DRIVE_DISTANCE = 10;

    }

    public class Falcon500
    {
        public static final int TICKS_PER_REV = 2046;
    }

    public class MotorPorts
    {
        public class Shooter
        {
            public static final int FLYWHEEL_DEVICE_NUMBER = 5;
            public static final int LIFT_BALL_DEVICE_NUMBER = 6;
            public static final int INDEXER_DEVICE_NUMBER = 7;
        }

        public class TwoMotors
        {
            public static final int RIGHT_MOTOR_1_DEVICE_NUMBER = 1;
            public static final int LEFT_MOTOR_1_DEVICE_NUMBER = 2;
        }

        public class FourMotors
        {
            public static final int LEFT_MOTOR_1_DEVICE_NUMBER = 4;
            public static final int RIGHT_MOTOR_1_DEVICE_NUMBER = 1;
            public static final int LEFT_MOTOR_2_DEVICE_NUMBER = 3;
            public static final int RIGHT_MOTOR_2_DEVICE_NUMBER = 2;
        }

        public class SixMotors
        {
            public static final int LEFT_MOTOR_1_DEVICE_NUMBER = 1;
            public static final int RIGHT_MOTOR_1_DEVICE_NUMBER = 14;
            public static final int LEFT_MOTOR_2_DEVICE_NUMBER = 2;
            public static final int RIGHT_MOTOR_2_DEVICE_NUMBER = 13;
            public static final int LEFT_MOTOR_3_DEVICE_NUMBER = 3;
            public static final int RIGHT_MOTOR_3_DEVICE_NUMBER = 12;
        }

        public class FourMotorFalcon500
        {
            public static final int LEFT_MOTOR_1_DEVICE_NUMBER = 1;
            public static final int RIGHT_MOTOR_1_DEVICE_NUMBER = 4;
            public static final int LEFT_MOTOR_2_DEVICE_NUMBER = 2;
            public static final int RIGHT_MOTOR_2_DEVICE_NUMBER = 3;
        }

        public class Collector
        {
            public static final int COLLECTOR_INTAKE_MOTOR_DEVICE_NUMBER = 12;
            public static final int COLLECTOR_MOTOR_DEVICE_NUMBER1 = 10;
            public static final int COLLECTOR_MOTOR_DEVICE_NUMBER2 = 11;
        }
    }

    public static class EncoderPorts
    {

        public class TwoMotorTalonSRX
        {

        }

        public class FourMotorTalonSRX
        {
            public static final int LEFT_A_PORT = 2;
            public static final int LEFT_B_PORT = 3;
            public static final int RIGHT_A_PORT = 4;
            public static final int RIGHT_B_PORT = 5;
        }

        public class SixMotorTalonSRX
        {

        }
    }
}