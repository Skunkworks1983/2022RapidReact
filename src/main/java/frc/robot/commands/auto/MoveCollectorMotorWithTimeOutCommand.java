package frc.robot.commands.auto;


import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.commands.collector.MoveCollectorMotorControllerCommand;
import frc.robot.subsystems.collector.Collector;

public class MoveCollectorMotorWithTimeOutCommand extends ParallelRaceGroup {

    public MoveCollectorMotorWithTimeOutCommand(Collector collector, boolean moveDownward, double time) {

        super(new MoveCollectorMotorControllerCommand(collector,moveDownward),new TimerCommand(time));
    }
}