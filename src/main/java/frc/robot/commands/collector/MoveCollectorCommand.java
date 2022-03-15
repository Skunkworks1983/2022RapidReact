package frc.robot.commands.collector;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.subsystems.Collector;

public class MoveCollectorCommand extends CommandBase
{
        private final Collector collector;
        private boolean moveDownward;
        private double endAngle;
        private double speed;
        private double threshold = 2;
        private double error;
        private double kp = 1/90.;
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
                if (moveDownward) {
                    endAngle = -90;
                } else {
                    endAngle = 0;
                }
        }

        @Override
        public void execute()
        {
            super.execute();

            error = endAngle - collector.getCollectorAngle();

            speed = kp * error;

                collector.setCollectorAngleSpeed(speed);
        }

        @Override
        public boolean isFinished()
        {
            return Math.abs(collector.getCollectorAngle() - endAngle) < 0.5;
        }

        @Override
        public void end(boolean interrupted)
        {
            super.end(interrupted);
        }
}
