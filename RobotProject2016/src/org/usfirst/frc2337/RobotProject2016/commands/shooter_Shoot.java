package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooter_Shoot extends Command {

	public shooter_Shoot(){
		requires(Robot.shooter);
	}
	protected void initialize() {
		// Disengages the shooter pin
		if(Robot.intakeWrist.getIntakeWristStatus() 
				&& RobotMap.okToShoot 
				//&& RobotMap.shooterArmOnTarget
				//&& RobotMap.visionOnTarget
				&& RobotMap.shooterRetractorPrimed
				&& RobotMap.shooterRetractorRetracted
				&& RobotMap.shooterRetractorRetracted)
			Robot.shooter.shooterShoot();	
		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		RobotMap.okToShoot = false;
	}

	protected void interrupted() {
		this.end();
	}

}
