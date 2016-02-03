package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class auton_SimpleReach extends Command {
	
    private int distance = 2;
	private int time = 3;
	private double speed = 0.5;
	
	public auton_SimpleReach()
	{
		requires(Robot.chassisPID);
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		Robot.chassisPID.resetGyro();
		Robot.chassisPID.readLeftEncoder();
		Robot.chassisPID.readRightEncoder();
		setTimeout(time);
	}


	protected void execute() {
		// TODO Auto-generated method stub
	    double yaw = Robot.chassisPID.readGyroYaw();
		Robot.chassisPID.arcadeDrive(speed, -yaw);
	}

	
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (Robot.chassisPID.encoderOnTargetLeft(distance) || isTimedOut());
	}


	protected void end() {
		// TODO Auto-generated method stub
		Robot.chassisPID.stopMotors();
	}

	
	protected void interrupted() {
		// TODO Auto-generated method stub
		this.end();
	}

}
