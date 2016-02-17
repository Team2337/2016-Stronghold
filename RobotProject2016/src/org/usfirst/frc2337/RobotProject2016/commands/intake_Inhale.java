
package org.usfirst.frc2337.RobotProject2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2337.RobotProject2016.Robot;

/**
 *  Intake ball,  DON'T as this wont set variable OkToShoot.
 *  Use Intake_ActivateMotors as it has the logic in it.
 */
public class intake_Inhale extends Command {

    public intake_Inhale() {

        requires(Robot.intake);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.intakeInhale();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stopMotors();
    }
}
