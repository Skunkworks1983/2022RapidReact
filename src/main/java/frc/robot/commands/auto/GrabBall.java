package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.collector.IntakeCommand;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.shooter.Shooter;


public class GrabBall extends SequentialCommandGroup
{
    //todo change name to *GrabsBalls*
    public GrabBall(Collector collector, Shooter shooter)
    {
        addCommands
                (
                        //new MoveCollectorCommand(collector, true),
                        new IntakeCommand(collector, shooter, .5)
                        //new MoveCollectorCommand(collector, false)
                );
    }
}
