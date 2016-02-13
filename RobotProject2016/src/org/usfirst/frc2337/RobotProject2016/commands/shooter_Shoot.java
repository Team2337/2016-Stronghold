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
		if(Robot.intakeWrist.getIntakeWristStatus() && RobotMap.okToShoot ) //&& RobotMap.shooterRetractPrimed)
			Robot.shooter.shooterShoot();
	}


	protected void execute() {
		// TODO Auto-generated method stub
		
	}


	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}


	protected void end() {
		// TODO Auto-generated method stub
		
	}


	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
