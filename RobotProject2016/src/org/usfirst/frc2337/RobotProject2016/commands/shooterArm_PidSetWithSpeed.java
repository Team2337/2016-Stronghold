
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class  shooterArm_PidSetWithSpeed extends Command {

    int setpoint;
	double upSpeed, downSpeed; //arm Speed 
    
    public shooterArm_PidSetWithSpeed(int setpoint) {

    	requires(Robot.shooterArmPID);
    	
    	this.setpoint = setpoint;
    }
    
    public shooterArm_PidSetWithSpeed(int setpoint, double upSpeed, double downSpeed) {

    	requires(Robot.shooterArmPID);
    	   	
    	//Make the variables for this command usable through out it
    	this.setpoint = setpoint;
    	this.upSpeed = upSpeed;
    	this.downSpeed = downSpeed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.shooterArmPID.getPIDController().setOutputRange(downSpeed, upSpeed);
        Robot.shooterArmPID.setSetpoint(setpoint);; //Run command in Lift Subsytem    	    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 return (Robot.shooterArmPID.onTarget());
   	 
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterArmPID.getPIDController().setOutputRange(Robot.shooterArmPID.teleopArmSpeedDown, Robot.shooterArmPID.teleopArmSpeedUp);
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
