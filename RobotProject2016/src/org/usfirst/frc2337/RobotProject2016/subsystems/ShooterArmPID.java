
package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.*;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class ShooterArmPID extends PIDSubsystem {

	private final Encoder shooterEncoder = RobotMap.shooterPIDEncoder;
    private final AnalogPotentiometer shooterArmPot = RobotMap.shooterArmPIDshooterArmPot;
    private final CANTalon shooterArmMotor = RobotMap.shooterArmPIDMotorA;
    
    //  Encoder = 1, POT = 2;
    private double encoderPotChooser = 1;
    private double layupShot;
    private double hookShot;
    private final double setPointTolerance = 0.05;
    private final double autonArmSpeedUp = .2;
    private final double autonArmSpeedDown = -.2;
    private final double teleopArmSpeedUp = .2;
    private final double teleopArmSpeedDown = -.2;
    private final double armToplimit = 4;
    private final double armBottomlimit = 0;
    
    public boolean armPIDstatus = false;
    public boolean armjoystickstatus = true;
    
    
    // Initialize your subsystem here
    public ShooterArmPID() {
       
        super("ShooterArmPID", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("ShooterArmPID", "PIDSubsystem Controller", getPIDController());

        getPIDController().setOutputRange(autonArmSpeedDown, autonArmSpeedUp);
        getPIDController().setInputRange(armBottomlimit, armToplimit);

        if(encoderPotChooser == 1){
        	//Specified angle value for Pot
        	layupShot = 4;
        	hookShot = 3;
        }else {
        	//Specified angle value for encoder
        	layupShot = 100;
        	hookShot = 80;
        }
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    public void initDefaultCommand() {
        setDefaultCommand(new shooterArm_DoNothing());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	if(encoderPotChooser == 1) {
    		return shooterEncoder.get();
    	} else {
    		return shooterArmPot.get();
    	}
    }
    

    protected void usePIDOutput(double output) {
        shooterArmMotor.pidWrite(output);
    }
   /**
    * Set the position of the shooterarm using the analog pot
    * @param setpoint
    */
    public void armSetpoint(int setpoint) {
    	setSetpoint(setpoint);
    }
    /**
     * Sets arm motor to raise the arm using armSpeedUp variable declared towards the top of the ShooterArm
     * Subsystem
     *    
    */
    public void armUp() {
    	shooterArmMotor.set(teleopArmSpeedUp);
    }
    /**
     * Sets arm motor to lower the arm using armSpeedDown variable declared towards the top of the ShooterArm
     * Subsystem
     * 
     */
    public void armDown() {
    	shooterArmMotor.set(teleopArmSpeedDown); 	
    }
    /**
     * positions shooter arm for Layup shot using layupShot variable declared towards the top of the ShooterArm
     * Subsystem
     * 
     */
    public void shooterLayup() {
    	shooterArmMotor.setSetpoint(layupShot);
    	}
    /**
     * positions shooter arm for hook shot using hookShot variable declared towards the top of the ShooterArm
     * Subsystem
     */
    public void shooterHookShot() {
    	shooterArmMotor.setSetpoint(hookShot);
    	}
    public void stopMotors() {
    	shooterArmMotor.set(0);
    }
}
