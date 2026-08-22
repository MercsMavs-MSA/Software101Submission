package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.WheelSubsystem;

public class TeleopCommands {
    
    private final WheelSubsystem wheel;

    public TeleopCommands(WheelSubsystem wheel)
    {
        this.wheel = wheel;
    }

    // This stuff is for software 201, teleop commands is never initialized

    public Command sequenceCommand()
    {
        return Commands.sequence(
            Commands.runOnce(() -> wheel.setVelocity(0.01), wheel),
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> wheel.setVelocity(0.5), wheel), // TODO: Get actual midway setpoint (or use TalonFX.setThrotle()?)
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> wheel.setVelocity(1.0), wheel), // TODO: get actual full speed setpoint (or use TalonFX.setThrotle()?)
            Commands.waitSeconds(1.0),
            Commands.runOnce(() -> wheel.setVelocity(0.0), wheel)
        );
    }

    public Command parrelelCommand() // i cant spell
    {
        return null;
    }

}
