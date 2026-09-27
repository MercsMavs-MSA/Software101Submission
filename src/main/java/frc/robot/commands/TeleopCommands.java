package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.PivotSubsystem;

public class TeleopCommands {
    private PivotSubsystem pivot;
    public TeleopCommands(PivotSubsystem pivot) {
        this.pivot = pivot;
    }

    //placeholders
    public Command positionSequence() {
        return Commands.sequence(
            Commands.runOnce(() -> pivot.goToPosition(0.2), pivot),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> pivot.goToPosition(0.2), pivot),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> pivot.goToPosition(0.2), pivot)
        );

    }

    public Command racePrint() {
        //placeholder
        double targetPos = 0.2;
        return Commands.race(
            //pushes the pivot toward the target, when it gets close enough its stops
            Commands.run(() -> pivot.goToPosition(targetPos), pivot).until(() -> Math.abs(pivot.getPosition() - targetPos) < 0.02),            Commands.run(() -> System.out.println("robot is moving to position"))
            
        //back to original after race complete
        ).andThen(Commands.runOnce(()-> pivot.goToPosition(0.0), pivot));
    }
}
