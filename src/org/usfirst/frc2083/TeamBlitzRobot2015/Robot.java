// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2083.TeamBlitzRobot2015;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc2083.TeamBlitzRobot2015.commands.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    DriveCommand driveCommand;
    GripperCommand gripperCommand;
    FourBarCommand fourBarCommand;
//    ClawCommand clawCommand;
//    ShootCommand shootCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        RobotMap.leftForwardMotorController = new CANJaguar(RobotMap.leftForwardMotorControllerID);
        RobotMap.leftBackMotorController = new CANJaguar(RobotMap.leftBackMotorControllerID);
        RobotMap.rightForwardMotorController = new CANJaguar(RobotMap.rightForwardMotorControllerID);
        RobotMap.rightBackMotorController = new CANJaguar(RobotMap.rightBackMotorControllerID);
        RobotMap.leftForwardMotorController.configNeutralMode(CANJaguar.NeutralMode.Brake);
        RobotMap.leftBackMotorController.configNeutralMode(CANJaguar.NeutralMode.Brake);
        RobotMap.rightForwardMotorController.configNeutralMode(CANJaguar.NeutralMode.Brake);
        RobotMap.rightBackMotorController.configNeutralMode(CANJaguar.NeutralMode.Brake);
        
        RobotMap.rightBackMotorController.setVoltageMode();
        RobotMap.leftBackMotorController.setVoltageMode();
        
        RobotMap.leftForwardMotorController.setVoltageMode(CANJaguar.kQuadEncoder, 360);
        RobotMap.rightForwardMotorController.setVoltageMode(CANJaguar.kQuadEncoder, 250);
        
        RobotMap.gripperLeftMotorController = new CANJaguar(RobotMap.gripperLeftMotorControllerID);
        RobotMap.gripperRightMotorController = new CANJaguar(RobotMap.gripperRightMotorControllerID);
        RobotMap.gripperLeftMotorController.configNeutralMode(CANJaguar.NeutralMode.Brake);
        RobotMap.gripperRightMotorController.configNeutralMode(CANJaguar.NeutralMode.Brake);
        RobotMap.gripperLeftMotorController.configLimitMode(CANJaguar.LimitMode.SwitchInputsOnly);
        RobotMap.gripperRightMotorController.configLimitMode(CANJaguar.LimitMode.SwitchInputsOnly);
        
        RobotMap.gripperLeftMotorController.setVoltageMode();
        RobotMap.gripperRightMotorController.setVoltageMode();
        
        RobotMap.fourBarMotorController = new CANTalon(RobotMap.fourBarMotorControllerID);
        RobotMap.fourBarMotorController.changeControlMode(CANTalon.ControlMode.PercentVbus);
        
        RobotMap.fourBarMotorController.setFeedbackDevice(CANTalon.FeedbackDevice.AnalogPot);
        RobotMap.fourBarMotorController.enableBrakeMode(true);
        RobotMap.fourBarMotorController.setForwardSoftLimit(756);
        RobotMap.fourBarMotorController.enableForwardSoftLimit(true);
        RobotMap.fourBarMotorController.setReverseSoftLimit(8);
        RobotMap.fourBarMotorController.enableReverseSoftLimit(true);
//        double p = 1;
//        double i = .01;
//        double d = 0;
//        double f = 0;
//        int izone = 0;
//        double closeLoopRampRate = 10;
//        int profile = 0;
        //RobotMap.fourBarMotorController.setPID(p , i , d, f, izone, closeLoopRampRate, profile);
       // RobotMap.fourBarMotorController.reverseSensor(false);
        
        
//        RobotMap.leftFront.setPositionMode(CANJaguar.kQuadEncoder, 360, 0.01, 0, 0);
//        RobotMap.rightFront.setPositionMode(CANJaguar.kQuadEncoder, 250, 0.01, 0, 0);
        
//        RobotMap.leftFront.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
//        RobotMap.rightFront.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
//        RobotMap.leftFront.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
//        RobotMap.rightFront.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
                
//            RobotMap.compressorRelay = new Relay(1);
//            RobotMap.compressorRelay.setDirection(Relay.Direction.kForward);
//            RobotMap.solenoidRelay = new Relay(2);
//            RobotMap.solenoidRelay.setDirection(Relay.Direction.kForward);
//            RobotMap.shooterValveSolenoid = new Solenoid(1);
//            RobotMap.shooterValveSolenoid.set(false);
                    
        // Initialize all subsystems
        CommandBase.init();
        driveCommand = new DriveCommand();
        gripperCommand = new GripperCommand();
        fourBarCommand = new FourBarCommand();
//            clawCommand = new ClawCommand();
        DriveCommand.xbox = new Joystick(0);
        GripperCommand.xbox = DriveCommand.xbox;
        FourBarCommand.xbox = DriveCommand.xbox;
//            ClawCommand.xbox = DriveCommand.xbox;
//            shootCommand = new ShootCommand();
//            ShootCommand.xbox = DriveCommand.xbox;
        
       
        
//            clawCommand.disableControl();
        driveCommand.disableControl();
        gripperCommand.disableControl();
        fourBarCommand.disableControl();
    }

    public void autonomousInit() {
    	RobotMap.auto = true;
    	RobotMap.autoTimer = System.currentTimeMillis();
    	driveCommand.enableControl();
    	driveCommand.start();
    	//System.out.println("ran Autonomous init");
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	if(System.currentTimeMillis()-RobotMap.autoTimer < 2500 ){
    		RobotMap.autoY = 0.5;
//    		System.out.println("autoY = .5, System Time millis = " 
//    				+ System.currentTimeMillis() + 
//    				", autoTimer = " + RobotMap.autoTimer);
    	} else {
    		RobotMap.autoY = 0;
    	} 
    	Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	RobotMap.auto = false;
        System.out.println("TELEOP INIT");
        driveCommand.enableControl();
        driveCommand.start();
        gripperCommand.enableControl();
        gripperCommand.start();
        fourBarCommand.enableControl();
        fourBarCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
