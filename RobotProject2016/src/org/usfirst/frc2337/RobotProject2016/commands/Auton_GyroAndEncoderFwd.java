package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class Auton_GyroAndEncoderFwd extends Command {

	public double m_speed;
	public double Kp = 0.03;
	public double yaw;
	public double m_target;

   // public Auton_GyroAndEncoderFwd(double speed, double encoderTarget) {
	 public Auton_GyroAndEncoderFwd(double speed) {
    	requires(Robot.chassisPID);
    	setTimeout(5);
    	//m_target = encoderTarget
    	m_speed = speed;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassisPID.resetEncoders();
    	Robot.chassisPID.resetGyro();
    	m_target = Robot.prefs.getDouble("AutonEncDist", 60.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	yaw = RobotMap.gyro.getAngle();
    	RobotMap.chassisDrive.drive(m_speed, yaw*Kp);
    	//Robot.chassisPID.arcadeDrive(m_speed, 0);
    	//Timer.delay(0.004);
    	System.out.println(m_target);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
         return ( isTimedOut() || (Robot.chassisPID.readLeftEncoder() > m_target));
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.chassisPIDchassisLeft1.enableBrakeMode(true);
    	RobotMap.chassisPIDchassisRight1.enableBrakeMode(true);
    	Robot.chassisPID.stopMotors();
    	RobotMap.chassisPIDchassisLeft1.enableBrakeMode(true);
    	RobotMap.chassisPIDchassisRight1.enableBrakeMode(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
