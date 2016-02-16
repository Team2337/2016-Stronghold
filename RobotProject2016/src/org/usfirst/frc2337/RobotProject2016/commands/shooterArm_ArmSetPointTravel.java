
package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class shooterArm_ArmSetPointTravel extends Command {
	
	
	public shooterArm_ArmSetPointTravel() {
		requires(Robot.shooterArmPID);	
	}

	
	protected void initialize() {
		RobotMap.shooterArmOnTarget = false;
		Robot.shooterArmPID.setSetpoint(Robot.shooterArmPID.travel);
	}
	
	
	protected void execute() {
	}


	protected boolean isFinished() {
		if( Robot.shooterArmPID.onTarget() )
			{RobotMap.shooterArmOnTarget = false;   // so can't shoot....DO WE WANT THIS???
			return true;}
	return false;
	}


	protected void end() {	
	}

	
	protected void interrupted() {
		this.end();	
	}

}
