package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Wheel.WheelConstants;
import frc.robot.subsystems.Wheel.WheelSubsystem;

public class TeleopCommands extends Command {
    private WheelSubsystem wheelSub;
    private WheelConstants wheelCon;

    public TeleopCommands(WheelSubsystem wheelSub, WheelConstants wheelCon) {
        this.wheelSub = wheelSub;
        this.wheelCon = wheelCon;
    }

    // public Command seqRangeWheel() {
    //     return Commands.runOnce(() -> {
    //         wheelSub.setVelocity(wheelCon.nearZeroRPS);
    //     }, wheelSub)

    //     .andThen(Commands.waitSeconds(1))

    //     .andThen(Commands.runOnce(() -> {
    //         wheelSub.setVelocity(wheelCon.midRPS);
    //     }, wheelSub))

    //     .andThen(Commands.waitSeconds(1))

    //     .andThen(Commands.runOnce(() -> {
    //         wheelSub.setVelocity(wheelCon.nearMaxRPS);
    //     }, wheelSub))
        
    //     .andThen(Commands.waitSeconds(5))
        
    //     .andThen(Commands.runOnce(() -> {
    //         wheelSub.setVelocity(0);
    //     }, wheelSub));
    // }

    // public Command parrCommand() {
    //     return Commands.runOnce(() -> {
    //         wheelSub.setVelocity(10);
    //     }, wheelSub)
        
    //     .andThen(Commands.waitSeconds(5))
        
    //     .andThen(Commands.runOnce(() -> {
    //         wheelSub.setVelocity(0);
    //     }, wheelSub))
        
    //     .alongWith(Commands.print("Hello I am a message being printed I love to be printed printing a message printed"));
    // }

    public Command seqRangeWheel() {
        return Commands.sequence(
            Commands.runOnce(() -> wheelSub.setVelocity(wheelCon.nearZeroRPS), wheelSub),
            Commands.waitSeconds(1),
            Commands.runOnce(() -> wheelSub.setVelocity(wheelCon.midRPS), wheelSub),
            Commands.waitSeconds(1),
            Commands.runOnce(() -> wheelSub.setVelocity(wheelCon.nearMaxRPS), wheelSub),
            Commands.waitSeconds(1)
        )
        
        .finallyDo(() -> wheelSub.setVelocity(0));
    }

    public Command parrCommand() {
        return Commands.race(
            Commands.run(() -> wheelSub.setVelocity(10), wheelSub),
            Commands.run(() -> Commands.print("Wheel spinning. Wheel velocity is " + wheelSub.getVelocity() + " rps.")),
            Commands.waitSeconds(5)
        )
        
        .finallyDo(() -> wheelSub.setVelocity(0));
    }
}
