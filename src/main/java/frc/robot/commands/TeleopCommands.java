package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ArmSubsystem;

public class TeleopCommands {
private ArmSubsystem arm;

public TeleopCommands(ArmSubsystem arm) {
		this.arm = arm;
    	}
	
	public Command exampleCommand() {
		return Commands.sequence(
            Commands.runOnce(() -> 
            arm.setPosition(0)),
            Commands.waitSeconds(1),
            Commands.runOnce(() ->
            arm.setPosition(0.39))
        );
    }
	public Command goToSP() {
        return Commands.parallel(
            arm.runOnce(() ->
            arm.setPosition(.19)), 
            Commands.print("Intake Position: .19"));
           
}
}


