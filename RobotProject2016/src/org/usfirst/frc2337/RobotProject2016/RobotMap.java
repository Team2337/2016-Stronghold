// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.RobotProject2016;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANSpeedController.ControlMode;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon intakeintakeLifterA;
    public static CANTalon intakeintakeMotorA;
    public static Ultrasonic intakeballSensor;
    public static DoubleSolenoid powerTakeOffptoSolenoid;
    public static AnalogGyro chassisPIDgyro;
    public static PowerDistributionPanel chassisPIDpowerDistributionPanel;
    public static Encoder chassisPIDdriveEncoder;
    public static Ultrasonic chassisPIDultrasonicSensor;
    public static AnalogAccelerometer chassisPIDaccelerometer;
    public static CANTalon chassisPIDchassisLeft1;
    public static CANTalon chassisPIDchassisLeft2;
    public static CANTalon chassisPIDchassisLeft3;
    public static CANTalon chassisPIDchassisRight1;
    public static CANTalon chassisPIDchassisRight2;
    public static CANTalon chassisPIDchassisRight3;
    public static AnalogPotentiometer shooterArmshooterArmPot;
    public static CANTalon shooterArmshooterArmMotorA;
    public static Solenoid scalerscalerAirActuator;
    public static Solenoid intakeWristintakeWristSolenoid;
    public static Solenoid chassisShiftershiftSolenoid;
   
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon intakeintakeMotorB;
    public static CANTalon shooterArmshooterArmMotorB;
    // DO NOT PUT ABOVE 
    public static AHRS gyro;
    public static RobotDrive chassisDrive;
    
    public static Solenoid ledGRIPCamera;
    
    //Start of init
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        intakeintakeLifterA = new CANTalon(9);
        LiveWindow.addActuator("Intake", "intakeLifterA", intakeintakeLifterA);
        
        intakeintakeMotorA = new CANTalon(8);
        LiveWindow.addActuator("Intake", "intakeMotorA", intakeintakeMotorA);
        
        intakeballSensor = new Ultrasonic(4, 5);
        LiveWindow.addSensor("Intake", "ballSensor", intakeballSensor);
        
        powerTakeOffptoSolenoid = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("PowerTakeOff", "ptoSolenoid", powerTakeOffptoSolenoid);
        
        chassisPIDgyro = new AnalogGyro(0);
        LiveWindow.addSensor("ChassisPID", "gyro", chassisPIDgyro);
        chassisPIDgyro.setSensitivity(0.003);
        chassisPIDpowerDistributionPanel = new PowerDistributionPanel(0);
        LiveWindow.addSensor("ChassisPID", "powerDistributionPanel ", chassisPIDpowerDistributionPanel);
        
        chassisPIDdriveEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("ChassisPID", "driveEncoder", chassisPIDdriveEncoder);
        chassisPIDdriveEncoder.setDistancePerPulse(1.0);
        chassisPIDdriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        chassisPIDultrasonicSensor = new Ultrasonic(2, 3);
        LiveWindow.addSensor("ChassisPID", "ultrasonicSensor", chassisPIDultrasonicSensor);
        
        chassisPIDaccelerometer = new AnalogAccelerometer(1);
        LiveWindow.addSensor("ChassisPID", "accelerometer ", chassisPIDaccelerometer);
        chassisPIDaccelerometer.setSensitivity(0.0);
        chassisPIDaccelerometer.setZero(2.5);
        chassisPIDchassisLeft1 = new CANTalon(2);
        LiveWindow.addActuator("ChassisPID", "chassisLeft1", chassisPIDchassisLeft1);
        
        chassisPIDchassisLeft2 = new CANTalon(4);
        LiveWindow.addActuator("ChassisPID", "chassisLeft2", chassisPIDchassisLeft2);
        
        chassisPIDchassisLeft3 = new CANTalon(6);
        LiveWindow.addActuator("ChassisPID", "chassisLeft3", chassisPIDchassisLeft3);
        
        chassisPIDchassisRight1 = new CANTalon(1);
        LiveWindow.addActuator("ChassisPID", "chassisRight1", chassisPIDchassisRight1);
        
        chassisPIDchassisRight2 = new CANTalon(3);
        LiveWindow.addActuator("ChassisPID", "chassisRight2", chassisPIDchassisRight2);
        
        chassisPIDchassisRight3 = new CANTalon(5);
        LiveWindow.addActuator("ChassisPID", "chassisRight3", chassisPIDchassisRight3);
        
        shooterArmshooterArmPot = new AnalogPotentiometer(2, 1.0, 0.0);
        LiveWindow.addSensor("ShooterArm", "shooterArmPot", shooterArmshooterArmPot);
        
        shooterArmshooterArmMotorA = new CANTalon(7);
        LiveWindow.addActuator("ShooterArm", "shooterArmMotorA", shooterArmshooterArmMotorA);
        
        scalerscalerAirActuator = new Solenoid(0, 0);
        LiveWindow.addActuator("Scaler", "scalerAirActuator", scalerscalerAirActuator);
        
        intakeWristintakeWristSolenoid = new Solenoid(0, 1);
        LiveWindow.addActuator("IntakeWrist", "intakeWristSolenoid", intakeWristintakeWristSolenoid);
        
        chassisShiftershiftSolenoid = new Solenoid(0, 2);
        LiveWindow.addActuator("ChassisShifter", "shiftSolenoid", chassisShiftershiftSolenoid);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        //CANTalon set control mode parameters
        //Current = 3 Disabled = 15 Follower = 5 PercentVbus = 0 Position = 1 Speed = 2 Voltage = 4
        intakeintakeMotorA.setControlMode(0);
        
        intakeintakeMotorB = new CANTalon(10);
        LiveWindow.addActuator("Intake", "intakeMotorB", intakeintakeMotorB);
        intakeintakeMotorB.setControlMode(5);
        intakeintakeMotorB.reverseOutput(true);
        intakeintakeMotorB.set(8);
        
        
        shooterArmshooterArmMotorB = new CANTalon(11);
        LiveWindow.addActuator("ShooterArm", "shooterArmMotorB", shooterArmshooterArmMotorB);
        shooterArmshooterArmMotorB.setControlMode(5);
        
        
        chassisDrive = new RobotDrive(chassisPIDchassisLeft1, chassisPIDchassisLeft2, chassisPIDchassisRight1, chassisPIDchassisRight2);
    	chassisDrive.setMaxOutput(1.0);
    	chassisDrive.setSensitivity(0.5);
    	chassisDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    	chassisDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);    	
    	chassisDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);   
    	chassisDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);   
    	
        try {
            /* Communicate w/navX MXP via the MXP SPI Bus.                                     */
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
            gyro = new AHRS(SerialPort.Port.kMXP);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
    }
}
