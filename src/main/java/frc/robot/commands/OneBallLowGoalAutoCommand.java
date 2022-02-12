package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Robot;
import frc.robot.subsystems.shooter.Shooter;

import java.awt.*;

public class OneBallLowGoalAutoCommand extends SequentialCommandGroup {
    public OneBallLowGoalAutoCommand() {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new FooCommand(), new BarCommand());
        super(
                // new DriveDistanceCommand(Drivebase drivebase, double distanceFT, double speed)
                 );
    }
}