
package org.usfirst.frc2337.RobotProject2016;

import org.usfirst.frc2337.RobotProject2016.commands.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

	//JOYSTICKS	
    public Joystick driverJoystick;
    public Joystick operatorJoystick;
    public Joystick driverStationControls;
    
    //VARIABLES FOR BUTTONS
    public int Green_A = 1;
    public int Red_B = 2;
    public int Blue_X = 3;
    public int Yellow_Y = 4; 
    public int Left_Bumper = 5;
    public int Right_Bumper = 6;
    public int Back_Button = 7;
    public int Start_Button = 8;
    public int Left_Stick_Button = 9;
    public int Right_Stick_Button = 10;
    //VARIABLES FOR AXIS
    public int Left_Stick_X = 1; 			// right is positive on the axis.  Can also refer to as the X axis.
    public int LEft_Stick_Y = 2;			// forward is negative on the axis.  Can also refer to as the Y axis.
    public int Triggers = 3;				// Left trigger is positive, 1 to 0.  Right trigger is negative, 0 to -1.
    public int Right_Stick_X = 4;  			// right is positive on the axis.
    public int Right_Stick_Y = 5; 			// forward is negative on the axis.
    public int Dpad_X = 6;					// Direction Pad X axis value only.  Note: The Joystick class can only handle 6 axis

    //BUTTONS
   
    public JoystickButton driveWithGyroAndEncoder;
    public JoystickButton driveWithGyro;
    public JoystickButton driveWithGyroNoTurn;
    public JoystickButton drive_Brake;
    
    public JoystickButton target;
    public JoystickButton targetWithJ;
    
    public JoystickButton intake;
    public JoystickButton intake_In;
    public JoystickButton intake_Out;
        
    public JoystickButton energizeWrist;
    
    public JoystickButton layup;
    public JoystickButton hookShot;
    public JoystickButton armSetPointBase;
    public JoystickButton armSetPointLongShot;
    public JoystickButton armSetPointShortShot;
    public JoystickButton armSetPointScale;
    
    public JoystickButton gripLed_On;
    public JoystickButton gripLed_Off;
    
    public JoystickButton scallerExtend;
    
    public JoystickButton lowToHigh;
    public JoystickButton hightoLow;
    
    public JoystickButton ptest;
    
    public AnalogAxisButton triggerR,triggerL;
    
    
    public OI() {
    	
        //
        // Assign controls for the Driver Joystick
        //
        driverJoystick = new Joystick(0);
        
        triggerR = new AnalogAxisButton(driverJoystick, 3, -0.5);
        triggerR.whenPressed(new intake_DoNothing());
        triggerL = new AnalogAxisButton(driverJoystick, 3, 0.5);
        triggerL.whenPressed(new intake_DoNothing());
        
        
        driveWithGyro = new JoystickButton(driverJoystick, Left_Bumper);
        driveWithGyro.whileHeld(new intake_ActivateMotors());
        
        //driveWithGyroAndEncoder = new JoystickButto1n(driverJoystick, Right_Bumper);
        //driveWithGyroAndEncoder.whenPressed(new Auton_GyroAndEncoderFwd(0.5));
        driveWithGyroNoTurn = new JoystickButton(driverJoystick, Right_Bumper);
        //driveWithGyroNoTurn.whileHeld(new chassis_DriveWithGyroNoTurn());
        driveWithGyroNoTurn.whileHeld(new chassis_DriveWithGyroNoTurn());
       

        target = new JoystickButton(driverJoystick, Start_Button);
        //target.whenPressed(new chassis_TargetWithGyro());
        target.whenPressed(new chassis_TargetWithGyroPID());
        
        ptest = new JoystickButton(driverJoystick, Green_A);
        //ptest.whenPressed(new scaler_pinPullOut());
        ptest.whenPressed(new GyroReset());

        lowToHigh = new JoystickButton(driverJoystick, Blue_X);
        lowToHigh.whenPressed(new chassisShifter_LowToHigh());
        
        hightoLow = new JoystickButton(driverJoystick, Yellow_Y);
        hightoLow.whenPressed(new chassisShifter_HighToLow());
        
        targetWithJ = new JoystickButton(driverJoystick, Red_B);
        targetWithJ.whileHeld(new chassis_TargetWithGyroPID());

        //
        // Assign controls for the Operator Joystick
        //
        operatorJoystick = new Joystick(2);
        /* 
        intake = new JoystickButton(operatorJoystick, Green_A);
        intake.whileHeld(new intake_ActivateMotors());
        
        energizeWrist = new JoystickButton(operatorJoystick, 4 );
        energizeWrist.whenPressed(new intakeWrist_Activate());
        
        layup = new JoystickButton(operatorJoystick, 7);
        layup.whenPressed(new shooter_Layup());
        
        hookShot = new JoystickButton(operatorJoystick, 8);
        hookShot.whenPressed(new shooter_HookShot());
        
        intake_In = new JoystickButton(operatorJoystick, 5);
        intake_In.whileHeld(new intake_Inhale());
        
        intake_Out = new JoystickButton(operatorJoystick, 6);
        intake_Out.whileHeld(new intake_Exhale());
        
        
        gripLed_On = new JoystickButton(operatorJoystick, Blue_X);
        gripLed_On.whileHeld(new led_GRIPOn());
        
        gripLed_Off = new JoystickButton(operatorJoystick, Yellow_Y);
        gripLed_Off.whileHeld(new led_GRIPOff());
        
        //Uses Switch to 'Change' state of CANTalon's, brake or coast.
        drive_Brake = new JoystickButton(driverJoystick, Green_A);
        drive_Brake.whenPressed(new chassis_DriveBrakePressed());
        drive_Brake.whenReleased(new chassis_DriveBrakeReleased());
        
        armSetPointBase = new JoystickButton(operatorControls, Back_Button);
        armSetPointBase.whenPressed(new shooterArm_ArmSetPointBase(1));
        
        armSetPointLongShot = new JoystickButton(operatorControls, Back_Button);
        armSetPointLongShot.whenPressed(new shooterArm_ArmSetPointBase(3));
       
        armSetPointShortShot = new JoystickButton(operatorControls, Back_Button);
        armSetPointShortShot.whenPressed(new shooterArm_ArmSetPointBase(4));
        
        armSetPointScale = new JoystickButton(operatorControls, Back_Button);
        armSetPointScale.whenPressed(new shooterArm_ArmSetPointBase(9));
        
        scallerExtend = new JoystickButton(operatorControls, Back_Button);
        scallerExtend.whenPressed(new scaler_pinPullOut());      
  */
        //
        // Assign controls for the Driver Station
        //
        driverStationControls = new Joystick(3);
  /*      
        scallerExtend = new JoystickButton(operatorControls, Back_Button);
        scallerExtend.whenPressed(new scaler_pinPullOut());
  */     
        
    }
    
    //
    //      Set Up Different SmartDashboards below for competition OR testing.
    //
    // 		In Robot.RobotPeriodic,
	// 		comment out test OR competition, depending on situation.
    //
    public void testSmartDashboard() {   	
        
        // SmartDashboard Buttons for use in testing
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("doNothing: fishstar", new doNothing(false, 0L));
        SmartDashboard.putData("intake_ActivateMotors", new intake_ActivateMotors());
        SmartDashboard.putData("chassis_DriveWithGyro", new chassis_DriveWithGyro());
        SmartDashboard.putData("intake_DoNothing", new intake_DoNothing());
        SmartDashboard.putData("PTO_DoNothing", new PTO_DoNothing());
        SmartDashboard.putData("led_DoNothing", new led_DoNothing());
        SmartDashboard.putData("shooterArm_DoNothing", new shooterArm_DoNothing());
        SmartDashboard.putData("scaler_DoNothing", new scaler_DoNothing());
        SmartDashboard.putData("intake_ActivateLifterMotor", new intake_ActivateLifterMotor(1));
        SmartDashboard.putData("intakeWrist_Activate", new intakeWrist_Extend());
        SmartDashboard.putData("chassisShifter_activate: activate", new chassisShifter_activate(false));
        SmartDashboard.putData("chassisShifter_activate: fish", new chassisShifter_activate(false));
        SmartDashboard.putData("camera_DoNothing", new camera_DoNothing());
        SmartDashboard.putData("intake_Inhale", new intake_Inhale());
        SmartDashboard.putData("intake_Exhale", new intake_Exhale());
  	  SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.gyro.isConnected());
      SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.gyro.isCalibrating());
      SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.gyro.getYaw());
      SmartDashboard.putNumber(   "IMU_Pitch",            RobotMap.gyro.getPitch());
      SmartDashboard.putNumber(   "IMU_Roll",             RobotMap.gyro.getRoll());
      SmartDashboard.putNumber(   "IMU_ANGLE",             RobotMap.gyro.getAngle());
      
      SmartDashboard.putBoolean(	"OK TO SHOOT", 			RobotMap.okToShoot);
      SmartDashboard.putBoolean(	"Ball Left", 			RobotMap.leftBallSensorState);
      SmartDashboard.putBoolean(	"Ball Right", 			RobotMap.rightBallSensorState);
      SmartDashboard.putBoolean(	"Got Ball", 			RobotMap.gotBallSensorState);
      SmartDashboard.putBoolean(	"Retractor", 			RobotMap.shooterRetractPrimed);
      
      SmartDashboard.putDouble("Encoder distance" , RobotMap.chassisPIDLeftEncoder.getRate());
      SmartDashboard.putNumber("Encoder distance" , RobotMap.chassisPIDLeftEncoder.getDistance());
      
      SmartDashboard.putBoolean("Shifter Status" , RobotMap.chassisShiftershiftSolenoid.get());
      //SmartDashboard.putDouble("AutonEncDist", RobotMap.autoEncoderDist);
      

        
     }
    
    public void competitionSmartDashboard() {     	
    	
        // SmartDashboard Buttons for use in competition
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("intake_ActivateMotors", new intake_ActivateMotors());
        SmartDashboard.putData("chassis_DriveWithGyro", new chassis_DriveWithGyro());
        SmartDashboard.putData("intake_DoNothing", new intake_DoNothing());
        SmartDashboard.putData("PTO_DoNothing", new PTO_DoNothing());
        SmartDashboard.putData("led_DoNothing", new led_DoNothing());
        
    	SmartDashboard.putBoolean(  "IMU_Connected",        RobotMap.gyro.isConnected());
        SmartDashboard.putBoolean(  "IMU_IsCalibrating",    RobotMap.gyro.isCalibrating());
        SmartDashboard.putNumber(   "IMU_Yaw",              RobotMap.gyro.getYaw());
        
        SmartDashboard.putBoolean(	"OK TO SHOOT", 			RobotMap.okToShoot);
        SmartDashboard.putBoolean(	"Ball Left", 			RobotMap.leftBallSensorState);
        SmartDashboard.putBoolean(	"Ball Right", 			RobotMap.rightBallSensorState);
        SmartDashboard.putBoolean(	"Got Ball", 			RobotMap.gotBallSensorState);
        SmartDashboard.putBoolean(	"Retractor", 			RobotMap.shooterRetractPrimed);

        
     }

    public Joystick getdriverJoystick() {
        return driverJoystick;
    }

    public Joystick getoperatorJoystick() {
        return operatorJoystick;
    }

}

