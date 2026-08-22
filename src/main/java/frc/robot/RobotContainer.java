package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.GoToArmPosition;
import frc.robot.subsystems.ArmSubsystem;

// wires everythings together
public class RobotContainer {
private final ArmSubsystem armSubsystem = new ArmSubsystem();
// controller for driving i guess
private final CommandXboxController driverController =
new CommandXboxController(Constants.DRIVER_CONTROLLER_PORT);

public RobotContainer() {
  configureBindings();
  }

  // this is were the buttons get hooked up
  private void configureBindings() {
// a button makes the arm move
    driverController.a().onTrue(
      new GoToArmPosition(armSubsystem, Constants.ARM_TARGET_POSITION));
  }

  // we dont have auto yet
  public Command getAutonomousCommand() {
  return null;
  }
}
