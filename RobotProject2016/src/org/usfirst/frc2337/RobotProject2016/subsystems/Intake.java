// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Ultrasonic;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Intake extends Subsystem {

	
    private final double inhaleSpeed = 1;
    private final double exhaleSpeed = -1;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon intakeLifterA = RobotMap.intakeintakeLifterA;
    private final CANTalon intakeMotorA = RobotMap.intakeintakeMotorA;
    private final Ultrasonic ballSensor = RobotMap.intakeballSensor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon intakeMotorB = RobotMap.intakeintakeMotorB;
    

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new intake_DoNothing());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     *Sets the variable speed of the Intake motor based on the input variable 
     *
     * @param speed(double)
     */
   public void setMotor(double speed) {
	   intakeMotorA.set(speed);
	   intakeMotorB.set(speed);
   }
   /**
    * Sets Intake motors to inhale at the variable inhaleSpeed which is defined at the top of the Intake subsystem
    */
   public void intakeInhale() {
	   intakeMotorA.set(inhaleSpeed);
	   intakeMotorB.set(inhaleSpeed);
   }
   /**
    * Sets Intake motors to exhale at the variable exhaleSpeed which is defined at the top of the Intake subsystem
    */
   public void intakeExhale() {
	   intakeMotorA.set(exhaleSpeed);
	   intakeMotorB.set(exhaleSpeed);
   }
   /**
    * Sets the motor speed for the intake to zero thereby stopping the intake. 
    */
   public void stopMotors() {
	   intakeMotorA.set(0);
	   intakeMotorB.set(0);
   }
}

