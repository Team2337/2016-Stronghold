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
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Intake extends Subsystem {

	
    private final double inhaleSpeed = 1;
    private final double exhaleSpeed = -1;

    private final CANTalon intakeMotorA = RobotMap.intakeintakeMotorA;
    private final CANTalon intakeMotorB = RobotMap.intakeintakeMotorB;
    private final DigitalInput leftBallSensor = RobotMap.intakeLeftBallSensor;
    private final DigitalInput rightBallSensor = RobotMap.intakeRightBallSensor;
    private final DigitalInput gotBallSensor = RobotMap.intakeGotBallSensor;
    		
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new intake_DoNothing());

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
   /**
    * See if the ball is center on left side 
    * @return
    */
   public boolean getLeftBallSensorState() {
	   //RobotMap.leftBallSensorState = leftBallSensor.get();
	   return leftBallSensor.get();
   }
   /**
    *  See if the ball is center on right side 
    * @return
    */
   public boolean getRightBallSensorState() {
	   //RobotMap.rightBallSensorState = rightBallSensor.get();
	   return rightBallSensor.get();
   }
   /**
    *  See if a ball is in the intake
    * @return
    */
   public boolean gotBallSensorState() {
	   //RobotMap.gotBallSensorState = gotBallSensor.get();
	   return gotBallSensor.get();
   }
   
   
}

