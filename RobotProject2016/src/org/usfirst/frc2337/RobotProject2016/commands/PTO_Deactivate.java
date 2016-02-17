package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PTO_Deactivate extends Command {

/**
 * Set the pneumatic pin for the scaling arm
 */
	public PTO_Deactivate() {
		requires(Robot.powerTakeOff);
	}
	/**
	 * 
	 */
	protected void initialize() {
		Robot.powerTakeOff.LiftOff();
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
