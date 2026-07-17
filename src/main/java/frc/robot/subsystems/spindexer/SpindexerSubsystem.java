// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.spindexer;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpindexerSubsystem extends SubsystemBase {
  private final TalonFX spindexerMotor = new TalonFX (SpindexerConstants.Spindexer_Motor_ID);
  private final VelocityVoltage request =
    new VelocityVoltage(0);
  /** Creates a new spindexer. */
  
  public SpindexerSubsystem() {
    var cfg = new TalonFXConfiguration();
    cfg.Slot0.kV = SpindexerConstants.SPINDEXER_KV;
    cfg.Slot0.kP = SpindexerConstants.SPINDEXER_KP;
    cfg.Feedback.RotorToSensorRatio = SpindexerConstants.GEAR_RATIO;
    cfg.CurrentLimits.StatorCurrentLimit = SpindexerConstants.StatorCurrentLimit;
    cfg.CurrentLimits.SupplyCurrentLimit = SpindexerConstants.SupplyCurrentLimit;
    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
    spindexerMotor.getConfigurator().apply(cfg);
  }


  public void goToVelocity(double rps) {
    System.out.println(rps);
    spindexerMotor.setControl(
      request.withVelocity(rps));
    // This method will be called once per scheduler run
  }
}
