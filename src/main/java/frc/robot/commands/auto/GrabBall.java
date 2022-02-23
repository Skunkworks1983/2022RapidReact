package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.MoveCollectorCommand;
import frc.robot.subsystems.Collector;


public class GrabBall extends SequentialCommandGroup
{
    //todo change name to *GrabsBalls*
    public GrabBall(Collector collector)
    {
        addCommands
                (
                        //new MoveCollectorCommand(collector, true),
                        //new IntakeCommand(collector, .5)
                        //new MoveCollectorCommand(collector, false) todo fix collector command, and all of this
                );
    }
}
