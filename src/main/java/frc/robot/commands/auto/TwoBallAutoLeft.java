package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveAndCollectCommandGroup;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.RotateCommand;
import frc.robot.commands.TimedDriveForwardCommandGroup;
import frc.robot.commands.TimedSpinUpAndShootAllBallsHighCommandGroup;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.shooter.Shooter;

public class TwoBallAutoLeft extends SequentialCommandGroup
{
    public TwoBallAutoLeft(Drivebase drivebase, Collector collector, Shooter shooter)
    {
        addCommands(new DriveAndCollectCommandGroup(drivebase, collector,2.92),
                    new DriveDistanceCommand(drivebase, -6),
                    new RotateCommand(drivebase, 170),
                    new TimedDriveForwardCommandGroup(1.0, 0.15, drivebase),
                    new TimedSpinUpAndShootAllBallsHighCommandGroup(shooter)
                   );
    }
}
// Drive forward 2.92 ft and start collector
// Drive backwards 6 ft
// Rotate 170 degrees clockwise
// Drive forward slowly for a certain amount of time
// Shoot both balls high for a certain amount of time