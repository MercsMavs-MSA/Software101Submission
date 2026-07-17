// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.spindexer;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class SpindexerSubsystem extends SubsystemBase {
  /** Creates a new SpindexerSubsystem. */
  private final TalonFX spindexerMotor = new TalonFX(SpindexerConstants.SPINDEXER_MOTOR_ID);
  private final VelocityVoltage request = new VelocityVoltage(0);
  public SpindexerSubsystem(){
    TalonFXConfiguration cfg = new TalonFXConfiguration();
    cfg.Slot0.kP = SpindexerConstants.SPINDEXER_KP;
    cfg.Slot0.kD = SpindexerConstants.SPINDEXER_KD;
    cfg.Slot0.kG = SpindexerConstants.SPINDEXER_KG; 
    cfg.Slot0.kV = SpindexerConstants.SPINDEXER_KV;
    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
    cfg.CurrentLimits.StatorCurrentLimit = SpindexerConstants.SPINDEXER_STATOR_CURRENT_LIMIT; 
    cfg.Feedback.SensorToMechanismRatio = SpindexerConstants.SPINDEXER_SENSOR_TO_MECHANISM_RATIO;
    cfg.CurrentLimits.SupplyCurrentLimit = SpindexerConstants.SPINDEXER_SUPPLY_CURRENT_LIMIT;
    spindexerMotor.getConfigurator().apply(cfg);
  }

  public void setSpindexerSpeed(double speed){
    spindexerMotor.setControl(request.withVelocity(speed));
  }
}

