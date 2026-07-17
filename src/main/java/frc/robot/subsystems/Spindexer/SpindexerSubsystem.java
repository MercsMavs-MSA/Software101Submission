// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Spindexer;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpindexerSubsystem extends SubsystemBase {
  /** Creates a new SpindexerSubsystem. */
  private final TalonFX spindexerMotor = 
    new TalonFX(SpindexerConstants.SPINDEXER_MOTOR_ID);
  private final VelocityVoltage request = 
    new VelocityVoltage(0);
  public SpindexerSubsystem() {
    var cfg = new TalonFXConfiguration();
    cfg.Slot0.kV = SpindexerConstants.SPINDEXER_KV;
    cfg.Slot0.kD = SpindexerConstants.SPINDEXER_KD;
    cfg.Slot0.kS = SpindexerConstants.SPINDEXER_KS;

    cfg.CurrentLimits.StatorCurrentLimit = SpindexerConstants.STATOR_LIMIT;
    cfg.CurrentLimits.StatorCurrentLimitEnable = SpindexerConstants.ENABLE_STATOR;

    cfg.CurrentLimits.StatorCurrentLimit = SpindexerConstants.SUPPLY_LIMIT;
    cfg.CurrentLimits.StatorCurrentLimitEnable = SpindexerConstants.ENABLE_SUPPLY;

    cfg.Feedback.SensorToMechanismRatio = SpindexerConstants.GEAR_RATIO;

    cfg.MotorOutput.NeutralMode = NeutralModeValue.Coast;

    
    
  }

  public void setVelocity(double rotationsPerSec)  {
    spindexerMotor.setControl(
      request.withVelocity(rotationsPerSec));
  }
    // This method will be called once per scheduler run
  
}
