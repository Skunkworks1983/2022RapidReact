package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.collector.DropCollector;

public class MoveCollectorCommand extends CommandBase
{
        private final Collector subSystem;
        private boolean moveDownward;

        public MoveCollectorCommand(Collector subSystem, boolean moveDownward)
        {
            this.subSystem = subSystem;
            this.moveDownward = moveDownward;
        }

        @Override
        public void initialize()
        {
            super.initialize();
            subSystem.setCollectorAngled(moveDownward);
        }

        @Override
        public void execute()
        {
            super.execute();
        }

        @Override
        public boolean isFinished()
        {
            return true;
        }

        @Override
        public void end(boolean interrupted)
        {
            super.end(interrupted);
        }
}
