// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.auto.*;
import frc.robot.commands.drivebase.ArcadeDrive;
import frc.robot.constants.Constants;
import frc.robot.services.Oi;
import frc.robot.subsystems.collector.Collector;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.climber.Climber;
import frc.robot.subsystems.drivebases.Drivebase4MotorFalcon500;
import frc.robot.subsystems.shooter.Shooter;


/**
 * The VM is configured to automatically run this class, and to call the methods corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot
{
    private Command autonomousCommand;
    
    private RobotContainer robotContainer;

    private Drivebase theDrivebase;

    private Oi theOi;

    private Collector theCollector;

    private Shooter theShooter;

    private SendableChooser autoChooser;

    private Climber theClimber;

    private Compressor theCompressor;

    /**
     * This method is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit()
    {
        // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
        // autonomous chooser on the dashboard.
        robotContainer = new RobotContainer();
        theDrivebase = new Drivebase4MotorFalcon500();
        theShooter = new Shooter();
        theCollector = new Collector();
        autoChooser = new SendableChooser();
        theClimber = new Climber();
        theCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        //autoChooser.addOption("twoBallHighRight", new TwoBallAutoRight(theDrivebase, theCollector, theShooter));
        //autoChooser.addOption("twoBallHighCenter", new TwoBallAutoCenter(theDrivebase, theCollector, theShooter));
        //autoChooser.addOption("twoBallHighLeft", new TwoBallAutoLeft(theDrivebase, theCollector, theShooter));
        autoChooser.addOption("ExitTarmac", new ExitTarmac(theDrivebase));
        autoChooser.addOption("oneBallAutosHigh", new OneBallAutosHighCommandGroup(theShooter, theDrivebase));
        autoChooser.addOption("oneBallAutosLow", new OneBallAutosLowCommandGroup(theShooter, theDrivebase));
        SmartDashboard.putData("autoChooser", autoChooser);
        SmartDashboard.putNumber("Shoot delay",0);
//        SmartDashboard.putNumber(Constants.Shooter.SMART_DASHBOARD_FLY_WHEEL_KP, Constants.Shooter.FLY_WHEEL_KP);
//        SmartDashboard.putNumber(Constants.Shooter.SMART_DASHBOARD_FLY_WHEEL_KF, Constants.Shooter.FLY_WHEEL_KF);
        theOi = new Oi(theCollector, theDrivebase, theShooter, theClimber);
        UsbCamera camera = CameraServer.startAutomaticCapture();
        camera.setFPS(15);
        camera.setResolution(160, 120);
    }
    
    
    /**
     * This method is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic methods, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic()
    {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }
    
    
    /** This method is called once each time the robot enters Disabled mode. */
    @Override
    public void disabledInit() {}
    
    
    @Override
    public void disabledPeriodic() {}
    
    
    /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
    @Override
    public void autonomousInit()
    {
        SendableChooser autoChooser = (SendableChooser) SmartDashboard.getData("autoChooser");
        autonomousCommand = (Command)autoChooser.getSelected();
        if (autonomousCommand != null)
        {
            autonomousCommand.schedule();
        }
    }
    
    
    /** This method is called periodically during autonomous. */
    @Override
    public void autonomousPeriodic() {}
    
    
    @Override
    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.

        Command drivebaseCommand = new ArcadeDrive(theDrivebase, theOi);
        if (autonomousCommand != null)
        {
            autonomousCommand.cancel();
        }
        drivebaseCommand.schedule();
    }
    
    
    /** This method is called periodically during operator control. */
    @Override
    public void teleopPeriodic() {}
    
    
    @Override
    public void testInit()
    {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
        theDrivebase.turnOffBrakes();
    }
    
    
    /** This method is called periodically during test mode. */
    @Override
    public void testPeriodic() {}
}
