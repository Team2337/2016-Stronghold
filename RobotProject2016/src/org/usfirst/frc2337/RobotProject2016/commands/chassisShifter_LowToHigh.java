package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class chassisShifter_LowToHigh extends Command {

	/**
	 * Change from high gear to low gear
	 */
	public chassisShifter_LowToHigh() {
		requires(Robot.chassisShifter);
	}
	
	/**
	 * Change from high gear to low gear 
	 */
	protected void initialize() {
	Robot.chassisShifter.highGear();
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
