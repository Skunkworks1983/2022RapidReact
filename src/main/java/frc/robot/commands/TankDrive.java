// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.services.Oi;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.ExampleSubsystem;



public class TankDrive extends CommandBase
{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Drivebase subsystem;
    private final Oi oi;

    public TankDrive(Drivebase subsystem, Oi oi)
    {
        this.subsystem = subsystem;
        addRequirements(subsystem);
        this.oi = oi;
    }
    
    
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}
    
    
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute()
    {
        subsystem.runMotor(oi.getLeftY(), oi.getRightY());
        System.out.println("CDFt Left: "+subsystem.getPosLeft()+", CDFt Right: "+subsystem.getPosRight()+", Degree: "+subsystem.getHeading()+", Calibrating: "+subsystem.isCalibrating());
    }
    
    
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
    
    
    // Returns true when the command should end.
    @Override
    public boolean isFinished()
    {
        return false;
    }
}
