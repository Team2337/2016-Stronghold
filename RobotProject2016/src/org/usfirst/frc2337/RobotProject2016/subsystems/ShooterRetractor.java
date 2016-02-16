package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.shooterRetractor_DoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class ShooterRetractor extends PIDSubsystem {
	
	private final CANTalon retractMotorA = RobotMap.shooterRetractMotorA;
	private final Encoder retractEncoder = RobotMap.shooterRetractPIDEncoder;
	
	private final double retractSpeedDown = -.2;
	private final double retractSpeedUp = .2;
	private final double retractForwardLimit = 1.0;
	private final double retractBackwardLimit = 0.5;
	
	public double primedRetractorPosition = 2;
	public double preppedRetractorPosition = 10;
	public double retractorDeadBand = 0.05; //used as a percentage

	public ShooterRetractor(double p, double i, double d, double period) {
        super("ShooterRetract", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("ShooterRetract", "PIDSubsystem Controller", getPIDController());

        getPIDController().setOutputRange(retractSpeedDown, retractSpeedUp);
        getPIDController().setInputRange(retractBackwardLimit, retractForwardLimit);

	}

	protected void initDefaultCommand() {
		setDefaultCommand(new shooterRetractor_DoNothing());
	}

	protected double returnPIDInput() {
		return retractEncoder.getDistance();
	}

	protected void usePIDOutput(double output) {
		retractMotorA.pidWrite(output);
	}
	
	public void setRetractorPosition(double setpoint) {
		this.setSetpoint(setpoint);
	}
	
	public void retractorPreppedPosition() {
		this.setSetpoint(preppedRetractorPosition);
	}
	
	public void retractorPrimedPosition() {
		this.setSetpoint(primedRetractorPosition);
	}
	
	public double getRetractorPosition() {
		return this.getPosition();
	}
	
	public double readRetractorEncoder() {
		return this.retractEncoder.getDistance();
	}
	
	


}
