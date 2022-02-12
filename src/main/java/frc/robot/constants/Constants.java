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
    public static final int LEFT_JOY_STICK_PORT = 0;
    public static final int RIGHT_JOY_STICK_PORT = 1;
    public static final int INTAKE_BUTTON = 3;
    public static final int REVERSE_INTAKE_BUTTON = 3;
    public static final int DROP_ON_BUTTON = 4;
    public static final int DROP_OFF_BUTTON = 4;
    public static final int UP_BUTTON = 5;
    public static final int DOWN_BUTTON = 5;
    public static final int LIFT_BALL_BUTTON = 2;
    public static final int FLY_WHEEL_BUTTONS = 1;
    public static final int INDEXER_BUTTON = 2;
    public static final int RUN_BOTH_LIFTS = 1;

    public class MotorPorts
    {
        public class Shooter
        {
            public static final int FLY_WHEEL_DEVICE_NUMBER = 5;
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

        public class collector
        {
            public static final int COLLECTOR_MOTOR_DEVICE_NUMBER = 5;
        } //todo change this idk

        public class collectorServo
        {
            public static final int COLLECTOR_SERVO_DEVICE_NUMBER = 0;
            public static final double COLLECTOR_SERVO_OPENED_ANGLE = 0;
            public static final double COLLECTOR_SERVO_CLOSED_ANGLE = 0;
        } //todo change to real angles

        public class collectorRelay //probably
        {
            public static final int COLLECTOR_RELAY_DEVICE_NUMBER = 1;
        }
    }


}
