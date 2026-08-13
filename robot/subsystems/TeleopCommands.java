package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class TeleopCommands {
    private ArmSubsystem arm;
    public TeleopCommands(ArmSubsystem arm) {
		this.arm = arm;
    	}
		
        public Command firstCommand() {
		return 
		Commands.sequence(
					Commands.runOnce(() -> arm.goToPosition(0)),
					Commands.waitSeconds(1),

					Commands.runOnce(() -> arm.goToPosition(0.11)),
					Commands.waitSeconds(1),

					Commands.runOnce(() -> arm.goToPosition(0.23)),
					Commands.waitSeconds(1),

					Commands.runOnce(() -> arm.goToPosition(0.0))
		);
    }
		public Command secondCommand() {
			return 
				Commands.race(
					Commands.run(() -> arm.goToPosition(0.15)),
					Commands.run(() -> Commands.print("Setpoint Reached")))
					.andThen(Commands.runOnce(() -> arm.goToPosition(0)));
		}	
}
