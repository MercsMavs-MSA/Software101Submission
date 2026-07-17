// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Spindexer;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpindexerSubsystem extends SubsystemBase {
  private final TalonFX spinMotor = new TalonFX(SpindexerConstants.MOTOR_ID);
  private final VelocityVoltage request = new VelocityVoltage(0);

  /** Creates a new SpindexerSubsystem. */
  public SpindexerSubsystem() {
    var cfg = new TalonFXConfiguration();
    cfg.Feedback.RotorToSensorRatio = SpindexerConstants.GEAR_RATIO;
    cfg.Slot0.kP = SpindexerConstants.kP;
    cfg.Slot0.kV = SpindexerConstants.kV;
    cfg.CurrentLimits.StatorCurrentLimit = SpindexerConstants.STATOR_LIMIT;
    cfg.CurrentLimits.SupplyCurrentLimit = SpindexerConstants.SUPPLY_LIMIT;
    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
    spinMotor.getConfigurator().apply(cfg);
  }

  public void spinSpindexer(double velocity) {
    spinMotor.setControl(
      request.withVelocity(velocity)
    );
  }

  @Override
  public void periodic() {
  }
}
