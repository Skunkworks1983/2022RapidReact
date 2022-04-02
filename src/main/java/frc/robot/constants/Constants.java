// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

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
        public static final int COLLECTOR_ENCODER_RESET_BUTTON = 8;
        public static final int SPIN_UP_FLYWHEEL_HIGH = 9;
        public static final int SPIN_UP_FLYWHEEL_LOW = 10;
        public static final int COLLECTOR_IN = 11;
        public static final int LOAD_BALLS_BUTTON = 12;
        public static final int INDEXER_SHOOT_WHEN_READY = 13;
        public static final int COLLECTOR_OUT = 14;
        public static final int INDEXER_OUTPUT_BUTTON = 15;
        public static final int CLIMBER_TOGGLE_BUTTON = 1; //todo figure out the button id
    }

    public class JoystickPorts
    {

        public static final int LEFT_JOY_STICK_PORT = 0;
        public static final int RIGHT_JOY_STICK_PORT = 1;
        public static final int BUTTON_STICK_PORT = 2;
    }

    public class Collector
    {
        public static final int GEAR_RATIO = 16;
        public static final int THRESHOLD = 2;
        public static final double KP_VALUE = 1/90.;
        //Might need to multiple number by 1024 because of the motor controller
        public static final double COLLECTOR_MOTOR_1_KP = 0.025;
        public static final double COLLECTOR_INTAKE_SPEED = -0.5;
    }

    public class Shooter
    {
        public static final double INDEXER_LOAD_SPEED = 0.275;
        public static final double LIFT_BALL_LOAD_SPEED = 5250;
        public static final double FLY_WHEEL_KP = 0.31;
        public static final double FLY_WHEEL_KF = .04885;
        public static final double HIGH_GOAL_SPEED = 13800;
        public static final double LOW_GOAL_SPEED = 9550;
        public static final double LIFT_BALL_KP = 0.065;
        public static final double LIFT_BALL_KF = 0.05644;
        public static final String SMART_DASHBOARD_FLY_WHEEL_KP = "flyWheelKp";
        public static final String SMART_DASHBOARD_FLY_WHEEL_KF = "flyWheelKf";
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
        public static final int EXIT_TARMAC_DRIVE_DISTANCE = 8;

    }

    public class Climber
    {
        public static final int RIGHT_SOLENOID_UP_PORT = 0;
        public static final int RIGHT_SOLENOID_DOWN_PORT = 1;
        public static final int LEFT_SOLENOID_UP_PORT = 2;
        public static final int LEFT_SOLENOID_DOWN_PORT = 3;
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

        public class Shooter
        {
            public static final int INTAKE_SENSOR_PORT = 0;
            public static final int BEFORE_FLYWHEEL_SENSOR_PORT = 1;
        }

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