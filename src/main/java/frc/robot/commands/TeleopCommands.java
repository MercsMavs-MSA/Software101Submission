package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Spindexer;

public class TeleopCommands {
    
    private final Spindexer spindexer;

    public TeleopCommands(Spindexer spindexer) {
        this.spindexer = spindexer;
    }
    public Command getSpindexerSequenceCommand() {
        return Commands.sequence(
            Commands.runOnce(() -> spindexer.setVelocity(0.5), spindexer),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> spindexer.setVelocity(10.0), spindexer),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> spindexer.setVelocity(25.0), spindexer)
        );
    }


    public Command getSpindexerPrintRaceCommand() {
        return Commands.race(
            Commands.run(() -> spindexer.setVelocity(15.0), spindexer),
            Commands.run(() -> System.out.println("Current Velocity: " + spindexer.getVelocity()), spindexer),
            Commands.waitUntil(() -> spindexer.getVelocity() >= 14.5)
        ).andThen(
            Commands.runOnce(() -> spindexer.setVelocity(0), spindexer)
        );
    }
}