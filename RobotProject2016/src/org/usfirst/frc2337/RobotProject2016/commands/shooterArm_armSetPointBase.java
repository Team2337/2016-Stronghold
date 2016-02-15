package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class shooterArm_ArmSetPointBase extends Command {
	
	int setpoint; 
	
	public shooterArm_ArmSetPointBase(int setpoint) {
		requires(Robot.shooterArmPID);
        this.setpoint = setpoint;		
	}

	
	protected void initialize() {
		Robot.shooterArmPID.armSetpoint(setpoint);
	}
	
	
	protected void execute() {
	}


	protected boolean isFinished() {
		return (Robot.shooterArmPID.onTarget());
	}


	protected void end() {	
	}

	
	protected void interrupted() {
		this.end();	
	}

}
