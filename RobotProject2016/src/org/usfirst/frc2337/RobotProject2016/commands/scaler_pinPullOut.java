package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class scaler_pinPullOut extends Command {

/**
 * pull out the pneumatic pin for the scaling arm
 */
	public scaler_pinPullOut() {
		requires(Robot.scaler);
	}
	/**
	 * 
	 */
	protected void initialize() {
		Robot.scaler.pinOut();
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
