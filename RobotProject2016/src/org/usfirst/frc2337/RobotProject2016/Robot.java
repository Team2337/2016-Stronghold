// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.RobotProject2016;

import java.io.IOException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.RobotProject2016.commands.*;
import org.usfirst.frc2337.RobotProject2016.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Intake intake;
    public static PowerTakeOff powerTakeOff;
    public static ChassisPID chassisPID;
    public static Scaler scaler;
    public static IntakeWrist intakeWrist;
    public static ChassisShifter chassisShifter;
    public static DriveCamera driveCamera;
    public static LED Led;
    public static ShooterArmPID shooterArmPID;
    public static ShooterRetract shooterRetract;
   
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Process GRIP;
    public static Process killGRIP;
    
    public static Preferences prefs;

	
    
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        intake = new Intake();
        powerTakeOff = new PowerTakeOff();
        chassisPID = new ChassisPID();
        scaler = new Scaler();
        intakeWrist = new IntakeWrist();
        chassisShifter = new ChassisShifter();
        driveCamera = new DriveCamera();
        Led = new LED();
        shooterArmPID = new ShooterArmPID();
        oi = new OI();

        // Autonomous
        autonomousCommand = new Auton_GyroFwd();
        
        
        //Preference variables
        prefs = Preferences.getInstance();
        //RobotMap.autoEncoderDist = prefs.getDouble("AutonEncDist", 60.0);
        //RobotMap.maxTurnFullSpeed = prefs.getDouble("NerdyTurnVarible", 0.45);
        /*
        try {
        	killGRIP = Runtime.getRuntime().exec(new String[]{"ps | grep grip | grep -v grep | cut -f 2 -d \" \" | xargs kill"});
        	
        } catch (IOException e1){
        	e1.printStackTrace();
        }
        
        try {
        	GRIP = Runtime.getRuntime().exec(new String[]{"/usr/local/frc/JRE/bin/java", "-jar", "/home/lvuser/grip.jar" , RobotMap.gripFilename});
        	
        } catch (IOException e){
        	e.printStackTrace();
        }
        */
    }

	public void robotPeriodic() {
		LiveWindow.run();

	  SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.gyro.isConnected());
      SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.gyro.isCalibrating());
      SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.gyro.getYaw());
      SmartDashboard.putNumber(   "IMU_Pitch",            RobotMap.gyro.getPitch());
      SmartDashboard.putNumber(   "IMU_Roll",             RobotMap.gyro.getRoll());
      SmartDashboard.putNumber(   "IMU_ANGLE",             RobotMap.gyro.getAngle());
      SmartDashboard.putBoolean("okToShoot", RobotMap.okToShoot);
      SmartDashboard.putBoolean("leftBall", RobotMap.intakeLeftBallSensor.get());
      SmartDashboard.putBoolean("RightBall", RobotMap.intakeRightBallSensor.get());
      SmartDashboard.putBoolean("gotBall", RobotMap.intakeGotBallSensor.get());
      SmartDashboard.putDouble("Encoder distance" , RobotMap.chassisPIDLeftEncoder.getRate());
      SmartDashboard.putNumber("Encoder distance" , RobotMap.chassisPIDLeftEncoder.getDistance());
      
      SmartDashboard.putBoolean("Shifter Status" , RobotMap.chassisShiftershiftSolenoid.get());
      //SmartDashboard.putDouble("AutonEncDist", RobotMap.autoEncoderDist);
      

	}

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	RobotMap.gyro.reset();
    	autonomousCommand = new Auton_GyroFwd();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        robotPeriodic();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        robotPeriodic();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
