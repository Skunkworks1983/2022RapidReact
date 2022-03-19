package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.collector.MoveCollectorMotorControllerCommand;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.Drivebase;

public class DriveDistanceAndMoveCollectorCommandGroup extends SequentialCommandGroup {
    public DriveDistanceAndMoveCollectorCommandGroup(Drivebase drivebase, Collector collector, Double distance, Boolean moveDownward) {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new FooCommand(), new BarCommand());
        super(
                new MoveCollectorMotorControllerCommand(collector, moveDownward),
                new DriveDistanceCommand(drivebase, distance)
            );
    }
}