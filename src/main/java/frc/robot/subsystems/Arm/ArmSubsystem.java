// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
    private final TalonFX armMotor =
      new TalonFX(Constants.ARM_MOTOR_ID);
  private final PositionVoltage request =
      new PositionVoltage(0);

  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    var cfg = new TalonFXConfiguration();
    cfg.Slot0.kP = Constants.ARM_KP;  // from tuning
    cfg.Slot0.kD = Constants.ARM_KD;
    cfg.Slot0.kG = Constants.ARM_KG;  // hold vs gravity
    armMotor.getConfigurator().apply(cfg);

  }
  
  @Override
  public void goToPosition(double rotations) {
    armMotor.setControl(
      request.withPosition(rotations));
    // This method will be called once per scheduler run
  }
}
