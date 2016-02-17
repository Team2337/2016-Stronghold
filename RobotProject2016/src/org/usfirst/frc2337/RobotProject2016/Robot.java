
package org.usfirst.frc2337.RobotProject2016;

import java.io.IOException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
    SendableChooser autonChooser;

    public static OI oi;
    public static Intake intake;
    public static PowerTakeOff powerTakeOff;
    public static ChassisPID chassisPID;
    public static Scaler scaler;
    public static IntakeWrist intakeWrist;
    public static ChassisShifter chassisShifter;
    public static DriveCamera driveCamera;
    public static LED Led;
    public static ShooterArmPID shooterArmPID;
    public static ShooterRetractor shooterRetractor;
    public static Shooter shooter;
   
    //public static Process GRIP;
    //public static Process killGRIP;
    
    public static Preferences prefs;
    public static Preferences prefsShooterRetract;

	
    
    
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();

        intake = new Intake();
        powerTakeOff = new PowerTakeOff();
        chassisPID = new ChassisPID();
        scaler = new Scaler();
        intakeWrist = new IntakeWrist();
        chassisShifter = new ChassisShifter();
        driveCamera = new DriveCamera();
        Led = new LED();
        shooterArmPID = new ShooterArmPID();
        shooter = new Shooter();
        
        
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it
        oi = new OI();
        

        // Autonomous
        //autonomousCommand = new Auton_GyroFwd();
        //AUTON CHOOSER
        //Instantiate the command used for the autonomous period

        autonChooser = new SendableChooser();
        autonChooser.addDefault("Do Nothing", new intake_DoNothing());
        autonChooser.addObject("Auton_GyroFwd", new Auton_GyroFwd());
        autonChooser.addObject("Auton1", new intake_DoNothing());
        
        //SmartDashboard Auton Selector
        SmartDashboard.putData("Auton Chooser", autonChooser);	
        
        
        //Preference variables
        prefs = Preferences.getInstance();
        prefsShooterRetract = Preferences.getInstance();
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
		
		// 
	    // comment out test OR competition, depending on situation
	    // 
	    oi.testSmartDashboard(); 
	    //oi.competitionSmartDashboard();


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
    	autonomousCommand = (Command) autonChooser.getSelected();
    	//autonomousCommand = new Auton_GyroFwd();
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
