package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Intake;

public class TeleopCommands {
    private final Intake intake;
    public TeleopCommands(Intake intake) {
        this.intake = intake;
    }

   
    public Command runSetpointSequence() {
        return Commands.sequence(
            Commands.runOnce(() -> intake.goToPosition(0.0), intake),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> intake.goToPosition(0.5), intake),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> intake.goToPosition(1.0), intake)
        );
    }

   
    public Command runArmWithConsolePrint() {
        return Commands.race(
            Commands.run(() -> intake.goToPosition(0.5), intake),
            Commands.print("Intake setpoint active!")
        );
    }
}
