package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PTO_Activate extends Command {

/**
 * pull out the pneumatic pin for the scaling arm
 */
	public PTO_Activate() {
		requires(Robot.powerTakeOff);
	}
	/**
	 * 
	 */
	protected void initialize() {
		Robot.powerTakeOff.LiftOn();
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
