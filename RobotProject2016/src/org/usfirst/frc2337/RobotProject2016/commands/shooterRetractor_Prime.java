package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterRetractor_Prime extends Command{

	private double m_deadBandPercent = 1.00 - Robot.shooterRetractor.retractorDeadBand;
	
	public shooterRetractor_Prime(){
		requires(Robot.shooterRetractor);
	}
	protected void initialize() {
		RobotMap.shooterRetractorPrimed = false;
		Robot.shooterRetractor.retractorPreppedPosition();
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		if( Robot.shooterRetractor.getRetractorPosition() 
				> 
		  (Robot.shooterRetractor.primedRetractorPosition * m_deadBandPercent) )
				{RobotMap.shooterRetractorPrimed = true;
				return true;
				}
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}

}
