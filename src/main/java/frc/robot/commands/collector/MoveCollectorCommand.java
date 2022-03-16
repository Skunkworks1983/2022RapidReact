package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.collector.Collector;

public class MoveCollectorCommand extends CommandBase
{
        private final Collector collector;
        private boolean moveDownward;
        private double endAngle;
        private double speed;
        private double error;
        private int onTarget;

        public MoveCollectorCommand(Collector collector, boolean moveDownward)
        {
            this.collector = collector;
            this.moveDownward = moveDownward;
        }

        @Override
        public void initialize()
        {
            super.initialize(); //start in upward position
            if (moveDownward)
            {
                endAngle = 90;
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

            error = endAngle - collector.getCollectorAngle();

            speed = Constants.Collector.KP_VALUE * error;

                collector.setCollectorAngleSpeed(speed);
        }

        @Override
        public boolean isFinished()
        {
            if (collector.getCollectorAngle() >= endAngle - Constants.Collector.THRESHOLD && collector.getCollectorAngle() <= endAngle + Constants.Collector.THRESHOLD)
            {
                onTarget++;
            }
            else
            {
                onTarget = 0;
            }

            return onTarget == 2;
        }

        @Override
        public void end(boolean interrupted)
        {
            collector.setCollectorAngleSpeed(0);
            super.end(interrupted);
        }
}
