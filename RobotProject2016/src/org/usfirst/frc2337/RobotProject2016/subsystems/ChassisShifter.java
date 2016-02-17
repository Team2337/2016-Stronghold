
package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class ChassisShifter extends Subsystem {

    private final Solenoid shiftSolenoid = RobotMap.chassisShiftershiftSolenoid;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {


        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Change to high gear
     */
    public void highGear() {
    	shiftSolenoid.set(true);
    }
    /**
     * Change to low gear
     */
    public void lowGear() {
    	shiftSolenoid.set(false);
    }
    /**
     * Get the status of Shifter Solenoid 
     * @return
     */
    public boolean getShiftStatus() {
    	return shiftSolenoid.get();
    }
    
}

