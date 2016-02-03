package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class auton_SimpleReach extends Command {
	
    private int distance = 2;    //TODO  need to determine encoder value
	private int time = 3;
	private double speed = 0.5;
	
	public auton_SimpleReach()
	{
		requires(Robot.chassisPID);
	}
	
	protected void initialize() {
		Robot.chassisPID.resetGyro();
		Robot.chassisPID.readLeftEncoder();
		Robot.chassisPID.readRightEncoder();
		setTimeout(time);
	}


	protected void execute() {
	    double yaw = Robot.chassisPID.readGyroYaw();
		Robot.chassisPID.arcadeDrive(speed, -yaw);
	}

	
	protected boolean isFinished() {
		return (Robot.chassisPID.encoderOnTargetLeft(distance) || isTimedOut());
	}


	protected void end() {
		Robot.chassisPID.stopMotors();
	}

	
	protected void interrupted() {
		this.end();
	}

}
