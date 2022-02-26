package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Collector;

public class MoveCollectorCommand extends CommandBase
{
        private final Collector collector;
        private boolean moveDownward;
        private double endAngle;
        private double speed;

        public MoveCollectorCommand(Collector collector, boolean moveDownward, double endAngle)
        {
            this.collector = collector;
            this.moveDownward = moveDownward;
            this.endAngle = endAngle;
        }

        @Override
        public void initialize()
        {
            super.initialize(); //start in upward position
            if (moveDownward)
            {
                endAngle = -90;
            }
            else
            {
                endAngle = 0;
            }
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
            if(collector.getCollectorAngle() >= endAngle)
            {
                 return true;
            }
            else
            {
                return false;
            }
        }

        @Override
        public void end(boolean interrupted)
        {
            super.end(interrupted);
        }
}
