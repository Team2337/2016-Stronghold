package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class chassisShifter_HighToLow extends Command {
	
	
	/**
	 * Change from low gear to high gear
	 */
	public chassisShifter_HighToLow() {
		requires(Robot.chassisShifter);
	}
	/**
	 * change from low gear to high gear 
	 */
	protected void initialize() {
		Robot.chassisShifter.lowGear();
	}

	protected void execute() {
	
	}
	
	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		
	}

	protected void interrupted() {
	this.end();
	}

}
