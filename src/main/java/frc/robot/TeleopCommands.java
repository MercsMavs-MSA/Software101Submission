package frc.robot;

import frc.robot.subsystems.arm.PivotConstants;
import frc.robot.subsystems.arm.PivotSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class TeleopCommands {

    private final PivotSubsystem pivot;

    public TeleopCommands(PivotSubsystem pivot) {
        this.pivot = pivot;
    }

    public Command moveUp() {
        return Commands.sequence(
            Commands.runOnce(() -> {
                pivot.goToPosition(
                    PivotConstants.OperatorConstants.PIVOT_OG_POS
                );
            }),

            Commands.waitSeconds(1.0),

            Commands.runOnce(() -> {
                pivot.goToPosition(
                    PivotConstants.OperatorConstants.PIVOT_MID_POS
                );
            }),

            Commands.waitSeconds(1.0),

            Commands.runOnce(() -> {
                pivot.goToPosition(
                    PivotConstants.OperatorConstants.PIVOT_FINAL_POS
                );
            })
        );
    }

    public Command moveBack() {
        return Commands.race(
            Commands.runOnce(() -> {
                pivot.goToPosition(
                    PivotConstants.OperatorConstants.PIVOT_OG_POS
                );
            }),

            Commands.run(() -> {
                System.out.println("Moving back to original position.");
                Commands.waitSeconds(1.0);
            })
        );
    }
}