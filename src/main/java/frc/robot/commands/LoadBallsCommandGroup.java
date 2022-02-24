package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.shooter.Shooter;

public class LoadBallsCommandGroup extends SequentialCommandGroup
{
    public LoadBallsCommandGroup(Shooter s)
    {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new OpenClawCommand(), new MoveArmCommand());
        super(new LoadFirstBallCommand(s), new LoadSecondBallCommand(s));
    }
}