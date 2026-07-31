package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Wheel.WheelConstants;
import frc.robot.subsystems.Wheel.WheelSubsystem;

public class TeleopCommands {
    private WheelSubsystem wheelSub;
    private WheelConstants wheelCon;

    public TeleopCommands(WheelSubsystem wheelSub, WheelConstants wheelCon) {
        this.wheelSub = wheelSub;
        this.wheelCon = wheelCon;
    }

    public Command seqRangeWheel() {
        return Commands.runOnce(() -> {
            wheelSub.setVelocity(wheelCon.nearZeroRPS);
        }, wheelSub)

        .andThen(Commands.waitSeconds(1))

        .andThen(Commands.runOnce(() -> {
            wheelSub.setVelocity(wheelCon.midRPS);
        }, wheelSub))

        .andThen(Commands.waitSeconds(1))

        .andThen(Commands.runOnce(() -> {
            wheelSub.setVelocity(wheelCon.nearMaxRPS);
        }, wheelSub))
        
        .andThen(Commands.waitSeconds(5))
        
        .andThen(Commands.runOnce(() -> {
            wheelSub.setVelocity(0);
        }, wheelSub));
    }
}
