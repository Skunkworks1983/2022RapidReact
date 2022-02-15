package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DropCollector;

public class DropCollectorCommand extends CommandBase
{
        private final DropCollector subSystem;
        private boolean open;

        public DropCollectorCommand (DropCollector subSystem, boolean open)
        {
            this.subSystem = subSystem;
            this.open = open;
        }

        @Override
        public void initialize()
        {
            super.initialize();
            subSystem.drop(open);
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
