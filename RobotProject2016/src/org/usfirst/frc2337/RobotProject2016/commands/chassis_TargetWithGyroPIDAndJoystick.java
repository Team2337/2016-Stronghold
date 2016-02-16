package org.usfirst.frc2337.RobotProject2016.commands;

import java.io.IOException;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class chassis_TargetWithGyroPIDAndJoystick extends PIDCommand {
	
	double[] defaultValue = new double[0];	

	double centerpnt = 172;
	double firstcenter, secondcenter;
	double deadband = 10;
	double turnValue, targetAngle, fishAngle, leftJoystick;
	double turnSpeed = 0.4;
	private Joystick joystickMain = Robot.oi.driverJoystick;
	double Kp = .003;
	double degreeConversion = 0.04;
	double setpoint;
	double timeout = 5.0;
	static double P;

	public chassis_TargetWithGyroPIDAndJoystick() {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .13, 0, 0.02);
		getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(-1, 1);
        LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());

	}

	protected double returnPIDInput() {
		return RobotMap.gyro.pidGet();
	}


	protected void usePIDOutput(double output) {
		leftJoystick = joystickMain.getRawAxis(1);
		Robot.chassisPID.arcadeDrive(leftJoystick, output);	
	}

	protected void initialize() {
		RobotMap.gyro.reset();

		this.setTimeout(timeout);
		RobotMap.gripTables = NetworkTable.getTable("GRIP/myContoursReport");
		
		P = Robot.prefs.getDouble("TargetPID-P", 0.2);
		double[] defaultValue = new double[0];
		double[] centerx = RobotMap.gripTables.getNumberArray("centerX", defaultValue);
		System.out.print("centerX: ");
			for (double centerX : centerx) {
				System.out.print(centerX + " ");
				firstcenter = centerx[0];
				//secondcenter = centerx[1];
			System.out.println();
			}
			
			turnValue = firstcenter - centerpnt;			///166 - 150 = 16
			targetAngle = turnValue * degreeConversion;   	/// 16 * .07  = ~ 1.12
//// REMOVE BEFORE PROD
			targetAngle = 15;
			System.out.println("targetAngle: " + targetAngle);
			this.setSetpoint(targetAngle);
		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		System.out.println("done" + RobotMap.gyro.getAngle());
		Robot.chassisPID.stopMotors();
	}

	protected void interrupted() {
		this.end();
	}

}
