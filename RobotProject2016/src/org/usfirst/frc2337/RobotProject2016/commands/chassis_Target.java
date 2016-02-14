package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class chassis_Target extends Command {

	

double[] defaultValue = new double[0];	

double centerpnt = 150;
double firstcenter, secondcenter;
double deadband = 10;
double turnValue;
double Kp = .003;



	protected void initialize() {
		RobotMap.gripTables = NetworkTable.getTable("GRIP/myContoursReport");
	}


	protected void execute() {
		double[] defaultValue = new double[0];
		double[] centerx = RobotMap.gripTables.getNumberArray("centerX", defaultValue);
		System.out.print("centerX: ");
		for (double centerX : centerx) {
			System.out.print(centerX + " ");
			firstcenter = centerx[0];
			//secondcenter = centerx[1];
		System.out.println();
		}
		

		if (firstcenter < (centerpnt - deadband))  {
			turnValue = firstcenter - (centerpnt - deadband) ;
			if (turnValue < -0.6) {
				turnValue = -0.6;
				}
			
			 
			
			Robot.chassisPID.arcadeDrive(0, turnValue);
			
		} else if (firstcenter > (centerpnt + deadband))  {
			turnValue = (centerpnt + deadband) + firstcenter;
			if (turnValue > 0.6) {
				turnValue = 0.6;
				}
		    Robot.chassisPID.arcadeDrive(0, turnValue);
		} else if (firstcenter == 0) {
			turnValue = 0;
		} else {
			turnValue = 0;
		}
		SmartDashboard.putDouble("turnValue",turnValue );
		}
		
		
		
	


	protected boolean isFinished() {

		return false;
	}


	protected void end() {

		
	}

	protected void interrupted() {

		
	}


}
