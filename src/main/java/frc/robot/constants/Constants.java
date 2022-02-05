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
    public static final int intakeButton = 1;

    public class MotorPorts
    {
        public class twoMotors
        {
            public static final int rightMotor1DeviceNumber = 1;
            public static final int leftMotor1DeviceNumber = 2;

        }

        public class fourMotors
        {
            public static final int leftMotor1DeviceNumber = 4;
            public static final int rightMotor1DeviceNumber = 1;
            public static final int leftMotor2DeviceNumber = 3;
            public static final int rightMotor2DeviceNumber = 2;
        }

        public class sixMotors
        {
            public static final int leftMotor1DeviceNumber = 1;
            public static final int rightMotor1DeviceNumber = 14;
            public static final int leftMotor2DeviceNumber = 2;
            public static final int rightMotor2DeviceNumber = 13;
            public static final int leftMotor3DeviceNumber = 3;
            public static final int rightMotor3DeviceNumber = 12;
        }

        public class collector
        {
            public static final int collectorMotorDeviceNumber = 1;
        } //todo change this idk

        public class collectorServo
        {
            public static final int collectorServoDeviceNumber = 0;
            public static final double collectorServoOpenedAngle = 0;
            public static final double collectorServoClosedAngle = 0;
        } //todo change to real angles

        public class collectorRelay //probly
        {
            public static final int collectorRelayDeviceNumber = 1;
        }
    }


}
