package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Wheel.WheelSubsystem;

public class TeleopCommands
{
    WheelSubsystem spindexer;
    public TeleopCommands(WheelSubsystem spindexer)
    {
        this.spindexer = spindexer;
    }

    public Command sequentialCommand()
    {
        return Commands.sequence(Commands.runOnce(() -> spindexer.setVelocity(0)), Commands.waitSeconds(1), Commands.runOnce(() -> spindexer.setVelocity(7.5)), Commands.waitSeconds(1), Commands.runOnce(() -> spindexer.setVelocity(15)));
    }

    public Command printRunCommand()
    {
        return Commands.race(
            Commands.run(() -> spindexer.setVelocity(15)),
            Commands.repeatingSequence(Commands.print("Hi the velocity is " + spindexer.getVelocity())),
            Commands.waitUntil(() -> {return spindexer.getVelocity() >= 15;})
        );
    }
}