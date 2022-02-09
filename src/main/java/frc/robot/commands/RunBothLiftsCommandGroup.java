package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.subsystems.shooter.Shooter;

public class RunBothLiftsCommandGroup extends ParallelCommandGroup {
    public RunBothLiftsCommandGroup(Shooter s, Button b) {
        // TODO: Add your sequential commands in the super() call, e.g.
        //           super(new FooCommand(), new BarCommand());
        super(new RunLiftBallCommand(s, b), new RunIndexerCommand(s, b));
    }
}