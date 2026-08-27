// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.PivotSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  PivotSubsystem pivot = new PivotSubsystem();
  public RobotContainer() {
    configureBindings();
  }
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private void configureBindings() {
    //placeholders
    m_driverController.b().onTrue(Commands.runOnce(() -> pivot.goToPosition(0.23))).onFalse(Commands.runOnce(() -> pivot.goToPosition(0)));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
