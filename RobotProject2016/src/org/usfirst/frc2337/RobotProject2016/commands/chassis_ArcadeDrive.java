package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.kauailabs.navx.frc.AHRS;
import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class chassis_ArcadeDrive extends Command {
	public double speed;
	public double Kp = 0.03;
	public double yaw;
	private Joystick joystickMain = Robot.oi.driverJoystick;

    public chassis_ArcadeDrive() {
    	requires(Robot.chassisPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (joystickMain.getRawAxis(2) > 0.2) {
    		speed = Robot.oi.driverJoystick.getRawAxis(2);
        	yaw = RobotMap.gyro.getAngle();
        	speed = speed * speed;
        	RobotMap.chassisDrive.drive(speed, yaw*Kp);
    	}
    	else {
    		RobotMap.gyro.reset();
    		double leftJoystick = joystickMain.getRawAxis(1);
	    	double turnJoystick = joystickMain.getRawAxis(4);
	    	
	    	turnJoystick = turnJoystick * Math.abs(turnJoystick);
	    	leftJoystick = leftJoystick * Math.abs(leftJoystick);
	    	 Robot.chassisPID.arcadeDrive(leftJoystick, turnJoystick);
	    	 SmartDashboard.putNumber(   "leftJoytick",             leftJoystick);
	    	 SmartDashboard.putNumber(   "turnJoystick",             turnJoystick);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}