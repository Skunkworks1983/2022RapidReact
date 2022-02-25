package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class MoveCollectorCommand extends CommandBase
{
        private final Collector collector;
        private boolean moveDownward;
        private double speed;

        public MoveCollectorCommand(Collector collector, boolean moveDownward, double speed)
        {
            this.collector = collector;
            this.moveDownward = moveDownward;
        }

        @Override
        public void initialize()
        {
            super.initialize();
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
