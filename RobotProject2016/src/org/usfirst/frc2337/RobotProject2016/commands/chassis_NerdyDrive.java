package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class chassis_NerdyDrive extends Command {
	public double speed;
	public double Kp = 0.03;
	public double yaw;
	private Joystick joystickMain = Robot.oi.driverJoystick;
	double turnOutput;
	double leftJoystick, turnJoystick,turnReduction;
	double absTurn, absSpeed,actualTurnMagnitude,actualTurn;
	double maxTurnFullSpeed = 0.45;
	double  deadband =0.1;
	
	public chassis_NerdyDrive() {
		requires(Robot.chassisPID);
	}
	
	
	
	protected void initialize() {
		
		
	}


	protected void execute() {
	
		RobotMap.gyro.reset();
		leftJoystick = joystickMain.getRawAxis(1);
		turnJoystick = joystickMain.getRawAxis(4);
		absTurn = Math.abs(turnJoystick);
		absSpeed = Math.abs(leftJoystick);
		
		turnReduction = (1 - maxTurnFullSpeed) * ((absTurn - deadband) / (1 - deadband));
    	actualTurnMagnitude = absTurn - (((absSpeed - deadband) / (1 - deadband)) * turnReduction);
    	
    	if (turnJoystick == 0) {
    		actualTurn = 0;
    	} else {
    		actualTurn = (absTurn/turnJoystick) * actualTurnMagnitude;
    	}

    	
    	 Robot.chassisPID.arcadeDrive(leftJoystick, actualTurn);
    	 
    	 SmartDashboard.putNumber(   "turnReduction",             turnReduction);
    	 SmartDashboard.putNumber(   "actualTurnMagnitude",             actualTurnMagnitude);
    	 SmartDashboard.putNumber(   "actualTurn",             actualTurn);
    	 SmartDashboard.putNumber(   "turnOutput",             turnOutput);
    	 SmartDashboard.putNumber(   "leftJoytick",             leftJoystick);
    	 SmartDashboard.putNumber(   "turnJoystick",             turnJoystick);
		
	}

	
	protected boolean isFinished() {
		
		
		return false;
	}

	
	protected void end() {
		
		
		
	}

	
	protected void interrupted() {
		
		
	}

}
