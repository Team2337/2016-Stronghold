

package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class IntakeWrist extends Subsystem {

    private final Solenoid intakeWristSolenoid = RobotMap.intakeWristintakeWristSolenoid;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new intakeWrist_Activate());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    /**
     * Energize the jazz hands or extend the intake wrist.
     */
    public void intakeExtend() {
    	intakeWristSolenoid.set(true);
    }
    /**
     * De-energize the jazz hands or extend the intake wrist.
     */
    public void intakeRetract() {
    	intakeWristSolenoid.set(false);
    }
    public boolean getIntakeWristStatus() {
    	return intakeWristSolenoid.get();
    }
    
}

