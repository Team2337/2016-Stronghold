package org.usfirst.frc2337.RobotProject2016.subsystems;

import org.usfirst.frc2337.RobotProject2016.RobotMap;
import org.usfirst.frc2337.RobotProject2016.commands.shooterRetract_DoNothing;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class ShooterRetract extends PIDSubsystem {
	
	private final CANTalon retractMotorA = RobotMap.shooterRetractMotorA;
	private final Encoder retractEncoder = RobotMap.shooterRetractPIDEncoder;
	
	private final double retractSpeedDown = -.2;
	private final double retractSpeedUp = .2;
	private final double retractForwardLimit = 1.0;
	private final double retractBackwardLimit = 0.5;

	public ShooterRetract(double p, double i, double d, double period) {
        super("ShooterRetract", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("ShooterRetract", "PIDSubsystem Controller", getPIDController());

        getPIDController().setOutputRange(retractSpeedDown, retractSpeedUp);
        getPIDController().setInputRange(retractBackwardLimit, retractForwardLimit);

	}

	protected void initDefaultCommand() {
		setDefaultCommand(new shooterRetract_DoNothing());
	}

	protected double returnPIDInput() {
		return retractEncoder.getDistance();
	}

	protected void usePIDOutput(double output) {
		retractMotorA.pidWrite(output);
	}
	
	public void setRetractPosition(double setpoint) {
		this.setSetpoint(setpoint);
	}
	
	public double getRetractPosition() {
		return this.getPosition();
	}
	
	public double readRetractEncoder() {
		return this.retractEncoder.getDistance();
	}
	
	


}
