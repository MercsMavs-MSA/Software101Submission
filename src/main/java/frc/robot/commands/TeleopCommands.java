package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.transfer.KickerSubsystem;
import frc.robot.subsystems.transfer.TransferConstants;

public class TeleopCommands {
    private final KickerSubsystem kicker;

    public TeleopCommands(KickerSubsystem kicker) {
        this.kicker = kicker;
    }

    public Command runKicker() {
        return Commands.startEnd(
            () -> kicker.goToVelocity(TransferConstants.KICKER_VELOCITY),
            () -> kicker.goToVelocity(0),
            kicker);
    }

    public Command kickerAntiJam() {
        return Commands.startEnd(
            () -> kicker.goToVelocity(TransferConstants.KICKER_ANTI_JAM_VELOCITY),
            () -> kicker.goToVelocity(0),
            kicker);
    }

    public Command rampUpSequence() {
        return Commands.sequence(
            Commands.runOnce(() -> kicker.goToVelocity(TransferConstants.KICKER_LOW_VELOCITY), kicker),
            Commands.waitSeconds(1),
            Commands.runOnce(() -> kicker.goToVelocity(TransferConstants.KICKER_MID_VELOCITY), kicker),
            Commands.waitSeconds(1),
            Commands.runOnce(() -> kicker.goToVelocity(TransferConstants.KICKER_VELOCITY), kicker),
            Commands.waitSeconds(1)
        ).finallyDo(() -> kicker.goToVelocity(0));
    }

   public Command spin() {
        return Commands.sequence(
            Commands.race(
                Commands.run(() -> kicker.goToVelocity(TransferConstants.KICKER_VELOCITY), kicker),
                Commands.print("Kicker spinning forward").andThen(Commands.idle()),
                Commands.waitSeconds(3)
            ),
            Commands.race(
                Commands.run(() -> kicker.goToVelocity(TransferConstants.KICKER_ANTI_JAM_VELOCITY), kicker),
                Commands.print("Kicker spinning in reverse").andThen(Commands.idle()),
                Commands.waitSeconds(3)
            )
        ).finallyDo(() -> kicker.goToVelocity(0));
    }

    public Command rampSequence() {
        return Commands.race(
            Commands.run(() -> kicker.goToVelocity(TransferConstants.KICKER_MID_VELOCITY), kicker),
            Commands.print("Kicker running at mid setpoint").andThen(Commands.idle()),
            Commands.waitSeconds(3)        
            ) .finallyDo(() -> kicker.goToVelocity(0));
    }

}