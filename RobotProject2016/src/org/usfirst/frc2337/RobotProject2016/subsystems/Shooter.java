package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private final Solenoid shooterSolenoid = RobotMap.ShooterPneumaticPin;
	
	protected void initDefaultCommand() {
	
	}
	public void shooterShoot(){
		shooterSolenoid.set(false);
	}
}
