package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ArmSubsystem;

// just calls goToPosition one time
public class GoToArmPosition extends InstantCommand {
public GoToArmPosition(ArmSubsystem armSubsystem, double rotations) {
// idk what super does but it works
super(() -> armSubsystem.goToPosition(rotations), armSubsystem);
  }
}
