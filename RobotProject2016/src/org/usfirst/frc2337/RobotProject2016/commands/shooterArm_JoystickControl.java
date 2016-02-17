
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class  shooterArm_JoystickControl extends Command {

	public boolean setPointSet = false;
	public double armSpeedFactor = 0.5;    //multiply joystick to reduce arm speed
	private double deadBand = 0.1;
	
    public shooterArm_JoystickControl() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooterArmPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setPointSet = false; 
    	Robot.shooterArmPID.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double armJoystickY = Robot.oi.operatorJoystick.getRawAxis(1);
    	armJoystickY = -armJoystickY;
    	
    	//Check the joystick for a dead band, if in do...
    	if ((armJoystickY > -deadBand ) && (armJoystickY < deadBand)) { //Dead band
    		
    		armJoystickY = 0;  //Set Motor to 0 if in dead band
    		
    		//If setPointSet, is not set (so false), run this ONCE and
    		//enable the Lift PID and set the PID to where the lift is
    		if (!setPointSet) {
    			Robot.shooterArmPID.enable(); //Enable Lift Pid
    			Robot.shooterArmPID.setSetpoint(Robot.shooterArmPID.getPosition()); //Set the Lift
    			//Make setPointSet true so this statement true so it won't loop
    			setPointSet = true; 
    		}
    	} else {		//If the Joystick is out of the dead band, do..
    		Robot.shooterArmPID.disable(); //Disable the Lift PID
    		//Make the motor be controlled by the joystick but at a multiplied speed
    		if  ((armJoystickY > 0) && (Robot.shooterArmPID.getPosition() < Robot.shooterArmPID.armToplimit)) {
    			RobotMap.shooterArmPIDMotorA.set(armSpeedFactor * armJoystickY); //Positive
    			
    		} else if ((armJoystickY < 0) && (Robot.shooterArmPID.getPosition() > Robot.shooterArmPID.armBottomlimit)) {
    			RobotMap.shooterArmPIDMotorA.set(armSpeedFactor * armJoystickY);	//Negative

    		} else  {
    			RobotMap.shooterArmPIDMotorA.set(0);
    		}
    		//Make the setPointSet to false, so if in dead band, the PID can reset
    		setPointSet = false;
    	}	// End Deadband
    }		// End Method

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.shooterArmPIDMotorA.set(0);
    	Robot.shooterArmPID.enable();
		Robot.shooterArmPID.setSetpoint(Robot.shooterArmPID.getPosition());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
