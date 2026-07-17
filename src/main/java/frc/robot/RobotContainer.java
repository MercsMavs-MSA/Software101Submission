package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.arm.ArmSubsystem;

public class RobotContainer {

  //Initialize Subsystems
  private final ArmSubsystem arm = new ArmSubsystem();

  //Initialize Controller
  private final CommandXboxController controller = new CommandXboxController(0);


  public RobotContainer() {configureBindings();}

  private void configureBindings() {
    controller.a().onTrue(arm.runOnce(() -> arm.goToPosition(ArmConstants.UP_POS)));
    controller.b().onTrue(arm.runOnce(() -> arm.goToPosition(ArmConstants.DOWN_POS)));

  }

  public Command getAutonomousCommand() {return null;}
}
