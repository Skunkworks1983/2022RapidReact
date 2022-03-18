package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.collector.Collector;


public class MoveCollectorMotorControllerCommand extends CommandBase
{
    private final Collector collector;
    private boolean moveDownward;

    public MoveCollectorMotorControllerCommand(Collector collector, boolean moveDownward)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(collector);
        this.collector = collector;
        this.moveDownward = moveDownward;
    }

    @Override
    public void initialize()
    {
        if (moveDownward)
        {
            collector.setCollectorAnglePosition(80);
        }
        else
        {
            collector.setCollectorAnglePosition(0);
        }
    }

    @Override
    public void execute()
    {
        //System.out.println("angle error:\t" + collector.getCollectorAngleError());
    }

    @Override
    public boolean isFinished()
    {
 //       System.out.println("angle: " + collector.getCollectorAngle() + " moveDownward " + moveDownward);
        // TODO: Make this return true when this Command no longer needs to run execute()
        if (moveDownward && Math.abs(collector.getCollectorAngle() - 80) < 3)
        {
            System.out.println("Ended");
            return true;
        }
        else if (!moveDownward && Math.abs(collector.getCollectorAngle()) < 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void end(boolean interrupted)
    {
        collector.stopCollectorPositionControl();
    }
}
