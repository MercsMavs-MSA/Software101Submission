// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.Console;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.spindexer.SpindexerSubsystem;

public class TeleopCommands {
	private SpindexerSubsystem spindexer;
	public TeleopCommands(SpindexerSubsystem spindexer) {
		this.spindexer = spindexer;
	}

	public Command sequentialCommand() {
		return Commands.sequence(
			Commands.runOnce(() -> {
				spindexer.stop();
			}, spindexer),
			Commands.waitSeconds(1),
			Commands.runOnce(() -> {
				spindexer.run(5);
			}, spindexer),
			Commands.waitSeconds(1),
			Commands.runOnce(() -> {
				spindexer.run(10);
			}, spindexer)
		);
	}

	public Command raceCommand() {
		return Commands.race(
			Commands.run(() -> {
				spindexer.run(10);
			}, spindexer),
			Commands.run(() -> {
				for (int i = 0; i < 10; i++) {
					System.out.println("printing");
				}
			}),
			Commands.waitSeconds(5)
		);
	}
}
