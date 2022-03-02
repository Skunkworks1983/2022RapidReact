package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class MoveCollectorCommand extends CommandBase
{
        private final Collector collector;
        private boolean moveDownward;
        private double endDegree;
        private double speed;

        public MoveCollectorCommand(Collector collector, boolean moveDownward, double endDegree)
        {
            this.collector = collector;
            this.moveDownward = moveDownward;
            this.endDegree = endDegree;
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
            if(moveDownward)
            {
                collector.setCollectorAngleSpeed(-speed);
            }
            else
            {
                collector.setCollectorAngleSpeed(speed);
            }
        }

        @Override
        public boolean isFinished()
        {
            return collector.getCollectorAngle() >= endDegree;
        }

        @Override
        public void end(boolean interrupted)
        {
            super.end(interrupted);
        }
}
