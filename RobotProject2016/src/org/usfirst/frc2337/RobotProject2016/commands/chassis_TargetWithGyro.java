package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class chassis_TargetWithGyro extends Command {

	

double[] defaultValue = new double[0];	

double centerpnt = 150;
double firstcenter, secondcenter;
double deadband = 10;
double turnValue, targetAngle, fishAngle, turnSpeed;
double Kp = .003;
double degreeConversion = 0.07;




	protected void initialize() {
		RobotMap.gripTables = NetworkTable.getTable("GRIP/myContoursReport");
		RobotMap.gyro.reset();
		
		
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
			
			if (targetAngle > 0) {
				turnSpeed = 0.5;
			} else {
				turnSpeed = -0.5;
			}
		SmartDashboard.putDouble("turnSpeed",turnSpeed );
	}

	protected void execute() {
		Robot.chassisPID.arcadeDrive(0, turnSpeed);	
	}

	protected boolean isFinished() {
		if (targetAngle > 0) {
			return (RobotMap.gyro.getYaw() > targetAngle);
		} else {
			return (RobotMap.gyro.getYaw() < targetAngle);
		}
}


	protected void end() {
		Robot.chassisPID.stopMotors();
	}

	protected void interrupted() {
		this.end();
	}


}
