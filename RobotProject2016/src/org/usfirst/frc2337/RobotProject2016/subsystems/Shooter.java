package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {

	private final Solenoid shooterSolenoid = RobotMap.ShooterPneumaticPin;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	protected void initDefaultCommand() {
		// Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
	}
	/**
     * Retracks pin for shooter to shoot.
     */
	public void shooterShoot(){
		shooterSolenoid.set(false);
	}
	public boolean getShooterValue(){
		return shooterSolenoid.get();
	}
}
