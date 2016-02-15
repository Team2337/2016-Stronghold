

package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject.RobotMap;
import org.usfirst.frc2337.RobotProject.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class Lift extends PIDSubsystem {
    CANTalon motor = RobotMap.masterliftMotor;
    AnalogPotentiometer potentiometer = RobotMap.liftPotentiometer;
    
    public DigitalInput competitionBot = RobotMap.competitionBot;

    
    //Lift PID variables
    double setPointTolerance = 0.05;
    
    /** Defines the max speed for the lift in the up direction for auton */
    public double autonMaxSpeedUp = .9; //0.8
    /** Defines the max speed for the lift in the down direction for auton */
    public double autonMaxSpeedDown = -1; //0.8
    /** Defines the max speed for the lift in the up direction for teleop */
    public double teleopMaxSpeedUp = .8;
    /** Defines the max speed for the lift in the up direction for teleop */
    public double teleopMaxSpeedDown = -.5;
    


    public double liftTopLimit = 7.76;			//   From 8.1 before Grabber
    public double liftBottomLimit = 0.82;		// Changed for Comp bot from .80 to compensate for roller wheels.
	
    //Make an array for the positions
    /** Defines the array for the teleop lift set positions */
    public double[][] setarray = new double[3][8];
       
    /** Define the initial tote value in the Lift PID set array */
    public int tote = 0; 			//Store the tote array number
    /** Define the initial base value in the Lift PID set array */    
    public int base = 0; 			//Store the base array number
    double autonTote = 0;
   
    /** define the state of the Lift PID */
    boolean PIDStatus = false;
    
    /** Define the set points for the lift. */
    double pos0,pos1,pos2,pos3,pos4,pos5,pos6,pos7,bottom,mid,top;
	public double autonPos1;
	public double autonPos2;
	public double autonPos3;
	public double autonPos4;
	public double autonPos5;
	public double autonPos6;
	public double autonPos7;
	public double autonPos8;
	public double autonPos9;
	public double autonPos10;
	public double autonPos11;
	public double autonPos12;
	public double autonPos13;
	public double autonPos14;
	public double autonPos15;
    
    //Joystick mode for switching back motor and lift
    public boolean joystickStatus = true;
    
    public static Preferences liftPref;
    
    /**
     * Sets the lift set points for the practice Robot.
     */
    public void setPracticeSetPoints() { 		// method to for set points on practice bot, called per practiceBot boolean/jumper
    	pos0 = 0.82; 	//Position 0
    	pos1 = 1.39;		//1
    	pos2 = 2.735;		//2   
    	pos3 = 4.04;		//3
    	pos4 = 5.4;		//4
    	pos5 = 6.7;		//5
    	pos6 = 2.475;		// Container Pickup with toes
    	pos7 = 2.6;		// Auton: second tote
    
    	bottom = 0;		//Bottom
    	mid = 0.4;		//Middle
    	top = 0.8;		//Top

    	autonPos1 = 1.8;
    	autonPos2 = 3.2;			///2.6  2/26/15
    	autonPos3 = 2.6;
    	autonPos4 = .85;
    	autonPos5 = 1.35;   //1.05;
    	autonPos6 = 1.65;
    	autonPos7 = 5.6;    // 6.0 on 2/23/2015   //5.6 at kettering
    	autonPos8 = .85;
    	autonPos9 = 5.0;
    	autonPos10 = .85;
    	autonPos11 = 1.05;
    	autonPos12 = .85;
    	autonPos13 = 3.5;
    	autonPos14 = 3.3;
    	autonPos15 = 2.5;
    }
    /**
     * Sets the lift set points for the Competition Robot.
     */
    public void setCompetitionSetPoints() {		// competition bot set points, called per practiceBot boolean/jumper (i.e. NO jumper)
    	pos0 = 0.82; 	//Position 0
    	pos1 = 1.39;		//1
    	pos2 = 2.735;		//2
    	pos3 = 4.04;		//3
    	pos4 = 5.4;		//4
    	pos5 = 6.7;		//5
    	pos6 = 2.475;		// Container Pickup with toes
    	pos7 = 2.6;		// Auton: second tote
    
    	bottom = 0;		//Bottom
    	mid = 0.4;		//Middle
    	top = 0.8;		//Top

    	/*
    	autonPos1 = 1.8;
    	autonPos2 = 7.0;
    	autonPos3 = 2.6;
    	autonPos4 = .85;
    	autonPos5 = 1.35;
    	autonPos6 = 1.65;
    	autonPos7 = 5.6;    //6.0 on 2/23/2015   //5.6 at kettering
    	autonPos8 = .85;
    	autonPos9 = .85;
    	autonPos10 = 7.0; //.85;
    	autonPos11 = 1.05;
    	autonPos12 = .85;
    	*/
    	
    	//  Because Compbot is now practice bot...
    	
      	autonPos1 = 1.8;
    	autonPos2 = 3.2;			///2.6  2/26/15
    	autonPos3 = 2.6;
    	autonPos4 = .85;
    	autonPos5 = 1.35;   //1.05;
    	autonPos6 = 1.65;
    	autonPos7 = 5.6;    // 6.0 on 2/23/2015   //5.6 at kettering
    	autonPos8 = .85;
    	autonPos9 = 5.0;
    	autonPos10 = .85;
    	autonPos11 = 1.05;
    	autonPos12 = .85;
    	autonPos13 = 3.5;
    	autonPos14 = 3.3;
    	autonPos15 = 2.5;
    }
    
    // Initialize your subsystem here
    public Lift() {

        super("Lift", 4.0, 0.0, 0.0);
        setAbsoluteTolerance(setPointTolerance);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Lift", "PIDSubsystem Controller", getPIDController());   
        
        getPIDController().setOutputRange(autonMaxSpeedDown, autonMaxSpeedUp);   //For the lift PID
        getPIDController().setInputRange(liftBottomLimit, liftTopLimit);
        
        
      //call method to set set-points based on DIO jumper 
        if (competitionBot.get()) {       	
        	setCompetitionSetPoints();
    	} else {
    		setPracticeSetPoints();
    	}
        	
        
        //Bottoms Positions
        setarray[0][0] = bottom + pos0;
        setarray[0][1] = bottom + pos1;
        setarray[0][2] = bottom + pos2;
        setarray[0][3] = bottom + pos3;
        setarray[0][4] = bottom + pos4;
        setarray[0][5] = bottom + pos5;
        setarray[0][6] = bottom + pos6;
        //setarray[0][7] = bottom + pos7;        
        //Middle Positions     
        setarray[1][0] = mid + pos0;
        setarray[1][1] = mid + pos1;
        setarray[1][2] = mid + pos2;
        setarray[1][3] = mid + pos3;
        setarray[1][4] = mid + pos4;
        setarray[1][5] = mid + pos5;				
        setarray[1][6] = mid + pos6;			
        //setarray[1][7] = mid + pos7;
        //Top Positions
        setarray[2][0] = top + pos0;
        setarray[2][1] = top + pos1;
        setarray[2][2] = top + pos2;
        setarray[2][3] = top + pos3;
        setarray[2][4] = top + pos4;
        setarray[2][5] = top + pos5; 				
        setarray[2][6] = top + pos6; 				
        //setarray[2][7] = top + pos7;
        

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LIFT_JoystickControlTEST());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        return potentiometer.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
        motor.pidWrite(-output);
    }
    
    //Grab the baseIn position, save the variable then set it global.
    /**
     * Based on the input sets the variable for the base lift height and set the setpoint for the lift using the existing tote position and the new base position
     * @param baseIn 
     *  int range from 0 to 2
     */ 
    public void setBase(int baseIn){
    	this.base= baseIn;
    	setSetpoint(setarray[this.base][this.tote]);
    	//System.out.println(setarray[this.base][this.tote]);
    }
   //Grab the toteIn position, save the variable then set it global.
    /**
     * Based on the input sets the variable for the tote lift height and set the setpoint for the lift using the existing base position and the new tote position
     * @param toteIn 
     *  int range from 0 to 7
     */
    public void setTote(int toteIn){
    	this.tote = toteIn;
    	setSetpoint(setarray[this.base][this.tote]);
    	//System.out.println(setarray[this.base][this.tote]);
    }
    /**
     * Directly sets the position of the lift to the desired height.
     * @param autonTote
     * double range from lift max to min. Roughly .8 to 8
     */
    public void setAutonPID(double autonTote){
    	this.autonTote = autonTote;
    	setSetpoint(autonTote);
    	//System.out.println(autonTote);
    }
    //StopPID, toggle option for stopping it. 
    /**
     * Disables the PID subsystem on the lift.
     */
    public void stopPID(){
    	this.PIDStatus = true;
    	this.disable();
    }
    /**
     * Enables the PID subsystem on the lift.
     */
    public void startPID() {
    	this.PIDStatus = false;
    	this.enable();
    }
    //Return the PID when needed to another command.
    /**
     * Returns the status of the PID subsystem to determine whether it is enabled.
     * @return true or false
     */
    public boolean getPIDStatus(){
    	return this.PIDStatus;
    }
    //
   /*
    public boolean LiftAutoTote() {
    	return liftAutoTote.get();
    }
    */
    
    /**
     * Returns the status of the operator station button to determine whether the joystick Y axis controls the lift or the back arm.
     * @return true or false
     */
    
    public boolean joystickModeStatus() {
    	return this.joystickStatus;
    }
    
    /**
     * Determines whether the robot is the practice or Comp bot based on the output of Dogital input 0;
     * @return  true or false
     */
    
    public boolean isCompetitionBot() {
    	return competitionBot.get();
    }
    /**
     * Set the Output range for the Lift during Telop.
     */
    public void setTeleopLiftSpeed() {
        getPIDController().setOutputRange(teleopMaxSpeedDown, teleopMaxSpeedUp);   //For the lift PID
    }
}
