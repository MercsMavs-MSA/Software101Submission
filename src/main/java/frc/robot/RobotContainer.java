package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.SpindexerSubsystem;
import frc.robot.commands.SpindexerSlowCommand;
import frc.robot.commands.SpindexerFastCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final SpindexerSubsystem m_spindexer = new SpindexerSubsystem();
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.a().whileTrue(new SpindexerSlowCommand(m_spindexer));

    m_driverController.b().whileTrue(new SpindexerFastCommand(m_spindexer));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
