// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Arm.ArmSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private final ArmSubsystem arm = new ArmSubsystem();
  private final CommandXboxController driver = new CommandXboxController(0);

  private void configureBindings() {
    driver.a().onTrue(arm.runOnce(() -> arm.goToPosition(Constants.ARM_POS_1)));
    driver.b().onTrue(arm.runOnce(() -> arm.goToPosition(Constants.ARM_POS_2)));
    
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
