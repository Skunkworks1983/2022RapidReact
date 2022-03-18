package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.shooter.Shooter;


public class ShootCommand extends CommandBase {

    private double speed;
    public ShootCommand(Shooter s, double speed)
    {
        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        shooter = s;
        addRequirements(shooter);
    }
    Shooter shooter;
    @Override
    public void initialize()
    {
        speed = shooter.getTarget();
        System.out.println(speed);
        shooter.setFlywheel(speed);
        shooter.setLiftBall(Constants.Shooter.LIFT_BALL_LOAD_SPEED);
        shooter.setIndexer(Constants.Shooter.INDEXER_LOAD_SPEED);
        System.out.println("Shooting now at: " + shooter.getFlyWheelSpeed());
    }

    @Override
    public void execute()
    {
        SmartDashboard.putNumber("Flywheel speed", shooter.getFlyWheelSpeed());
    }

    @Override
    public boolean isFinished()
    {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted)
    {
        shooter.setFlywheel(0);
        shooter.setLiftBall(0);
        shooter.setIndexer(0);
    }
}
