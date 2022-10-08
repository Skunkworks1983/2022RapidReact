package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.commands.collector.MoveCollectorMotorControllerCommand;
import frc.robot.commands.drivebase.DriveDistanceCommand;
import frc.robot.subsystems.collector.Collector;

public class MoveCollectorMotorWIthTimeOutCommand extends ParallelRaceGroup {

    public MoveCollectorMotorWIthTimeOutCommand(Collector collector, boolean moveDownward, double time) {

        super(new MoveCollectorMotorControllerCommand(collector,moveDownward),new TimerCommand(time));
    }
}