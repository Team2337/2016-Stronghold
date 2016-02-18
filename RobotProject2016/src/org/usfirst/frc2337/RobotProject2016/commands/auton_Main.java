package org.usfirst.frc2337.RobotProject2016.commands;

import org.usfirst.frc2337.RobotProject2016.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class auton_Main extends CommandGroup {

	
	
	double location;
	/**
	 * This is the AUTONOMOUS FILE
	 * ---------------------------
	 * This will be the backbones of how auton is created
	 * by using a command group and adding SEQUENTIAL or
	 * PARALLEL commands based on user input in SmartDashboard (prefences)
	 * or NerdyWeb Interface (network tables) [still needs improvement].
	 */
	public auton_Main()
	{
		addSequential(new Auton_GyroAndEncoderFwd(600)); //MOVE TO REACH LINE

		location = RobotMap.autonTables.getNumber("locationType", 1);
		if ((location > 0) && (6 < location)) //IF DEFENSE IS GYRO FORWARD & ENCODER ONLY
		{
			addSequential(new Auton_GyroAndEncoderFwd(1000)); //MOVE OVER DEFENSE WITH AMOUNT OF TICKS
		} else if(location == 7) { //CHEVAL DE FRISE
			//RUN COMMAND FOR CHEVY
		} else  if (location == 8) { //PORTICULLUS
			//WOULD THIS BE addSequential(new Auton_GyroAndEncoderFwd(1000)); ???
			
		}
		
	}

}
