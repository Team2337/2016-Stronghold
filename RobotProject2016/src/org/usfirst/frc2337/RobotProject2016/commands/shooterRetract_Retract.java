package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_Retract extends Command{

	public double primedRetractPosition = 2;
	public double winchPreppedPosition = 10;
	//public boolean shooterRetractPrimed;
	
	public shooterRetract_Retract(){
		requires(Robot.shooterRetract);
	}
	protected void initialize() {
		// Auto-generated method stub
		RobotMap.shooterRetractPrimed = false;
		Robot.shooterRetract.setRetractPosition(primedRetractPosition);
	}

	protected void execute() {
		// Auto-generated method stub
		if(Robot.shooterRetract.getRetractPosition() < 100)
			Robot.shooterRetract.setRetractPosition(winchPreppedPosition);
	}

	protected boolean isFinished() {
		// Auto-generated method stub
		if(Robot.shooterRetract.getRetractPosition() > 500){
			RobotMap.shooterRetractPrimed = true;
			return true;
		}
		return false;
	}

	protected void end() {
		// Auto-generated method stub
		
	}

	protected void interrupted() {
		// Auto-generated method stub
		
	}

}
