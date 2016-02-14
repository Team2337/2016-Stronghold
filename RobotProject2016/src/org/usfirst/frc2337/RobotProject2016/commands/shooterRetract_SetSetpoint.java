package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class shooterRetract_SetSetpoint extends Command {
    
	public double m_target;
	public shooterRetract_SetSetpoint(){
		requires(Robot.shooterRetract);
	}
	protected void initialize() {
		m_target = Robot.prefsShooterRetract.getDouble("ShooterRetractSetPoint", 5.0);
		Robot.shooterRetract.setRetractPosition(m_target);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}

}
