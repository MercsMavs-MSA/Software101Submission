// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.IntakeRollers.IntakeRollersSubsystem;
import frc.robot.subsystems.Pivot.PivotSubsystem;

/** Add your docs here. */
public class TeleopCommands {
    private IntakeRollersSubsystem rollers;
    private PivotSubsystem pivot;

    public TeleopCommands(IntakeRollersSubsystem rollers)
    {
        this.rollers = rollers;
    }

    public TeleopCommands(PivotSubsystem pivot)
    {
        this.pivot = pivot;
    }

    public Command sequentialCommandRoller()
    {
        return Commands.runOnce(() -> rollers.goToVelocity(0.05))
        .andThen(Commands.waitSeconds(1.0))
        .andThen(Commands.runOnce(() -> rollers.goToVelocity(0.1)))
        .andThen(Commands.waitSeconds(1.0))
        .andThen(Commands.runOnce(() -> rollers.goToVelocity(0.2)));
    }

    public Command sequentialCommandPivot()
    {
        return Commands.runOnce(() -> pivot.goToPosition(0.05))
        .andThen(Commands.waitSeconds(1.0))
        .andThen(Commands.runOnce(() -> pivot.goToPosition(0.1)))
        .andThen(Commands.waitSeconds(1.0))
        .andThen(Commands.runOnce(() -> pivot.goToPosition(0.2)));

    }

    public Command parallelRaceRoller()
    {
    
        return Commands.race(
            Commands.run(() -> rollers.goToVelocity(0.2)),
            Commands.print("Parallel Race"),
            Commands.waitSeconds(5)
        );
    }

    public Command parallelRacePivot()
    {
        return Commands.race(
            Commands.run(() -> pivot.goToPosition(0.2)),
            Commands.print("Parallel Race"),
            Commands.waitSeconds(5)
        );
    }











}
