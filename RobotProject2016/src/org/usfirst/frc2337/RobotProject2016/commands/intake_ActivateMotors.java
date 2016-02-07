

package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.RobotProject2016.Robot;
import org.usfirst.frc2337.RobotProject2016.RobotMap;

/**
 *
 */
public class intake_ActivateMotors extends Command {

    private double m_speed;
 
    boolean leftState;
    boolean rightState;
    boolean ballState;
    
    public intake_ActivateMotors() {
        requires(Robot.intake);
    }


    protected void initialize() {
    	RobotMap.okToShoot = false;
    	m_speed = 1;
    }


    protected void execute() {
    	leftState = Robot.intake.getLeftBallSensorState();
    	rightState = Robot.intake.getRightBallSensorState();
    	ballState = Robot.intake.gotBallSensorState();
    	
    	if ((leftState == false) || (rightState == false)) {
    		 m_speed = 1;
    		
    	} else if ((leftState == true) && (rightState == true)){
    		if (ballState == true) {
    			m_speed = 0.1;
    			RobotMap.okToShoot = true;
    			System.out.println("got here");;
    		} else {
    			m_speed = 1;
    			RobotMap.okToShoot = false;
    		}
    	
    		
    	}
    	
    	Robot.intake.setMotor(m_speed);
    	
    	
    	
    }

    protected boolean isFinished() {
        return false;
    }

   
    protected void end() {
    }

   
    protected void interrupted() {
    	Robot.intake.setMotor(0);
    }
}
