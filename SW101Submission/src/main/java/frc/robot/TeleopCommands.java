// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
//import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.WheelSubsystem;
/**
 * Holds factory methods for teleop-triggered commands. Keeping these here (rather than inline
 * in RobotContainer) keeps configureBindings() readable as the number of commands grows.
 */
public class TeleopCommands {
  private final WheelSubsystem wheelSubsystem;

  public TeleopCommands(WheelSubsystem wheelSubsystem) {
    this.wheelSubsystem = wheelSubsystem;
  }

  /**
   * Simple diagnostic command: prints the wheel's current velocity to the console.
   * Bound to the 'A' button in RobotContainer.
   */
  public Command printRunCommand() {
    return Commands.runOnce(
        () -> System.out.println("Wheel velocity: " + wheelSubsystem.getVelocity() + " rps"));
  }

  /**
   * Example sequential command: spins the wheel up, holds briefly, then stops.
   * Bound to the 'B' button in RobotContainer.
   */
  public Command sequentialCommand() {
    return Commands.sequence(
        Commands.runOnce(() -> wheelSubsystem.setVelocity(20), wheelSubsystem),
        Commands.waitSeconds(1.0),
        Commands.runOnce(() -> wheelSubsystem.setVelocity(0), wheelSubsystem));
  }
}