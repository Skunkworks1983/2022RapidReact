package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.constants.Constants;

public class Oi
{
    Joystick leftStick;
    Joystick rightStick;

    public Oi()
    {
        leftStick = new Joystick(Constants.LEFT_JOY_STICK_PORT);
        rightStick = new Joystick(Constants.RIGHT_JOY_STICK_PORT);
        //todo make button class
    }

    public double getLeftY()
    {
        return leftStick.getY();
    }
    public double getRightY()
    {
        return rightStick.getY();
    }
    public double getLeftX(){return leftStick.getX();}
    public double getRight(){return rightStick.getX();}
}
