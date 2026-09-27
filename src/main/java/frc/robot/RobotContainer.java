// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.TeleopCommands;
import frc.robot.subsystems.PivotSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  PivotSubsystem pivot = new PivotSubsystem();
  private final TeleopCommands teleopCommands = new TeleopCommands(pivot);
  public RobotContainer() {
    configureBindings();
  }
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private void configureBindings() {
    //placeholders
    m_driverController.a().onTrue(teleopCommands.positionSequence());
    m_driverController.b().onTrue(teleopCommands.racePrint());

  }

  public Command getAutonomousCommand() {
    return null;
  }
}
