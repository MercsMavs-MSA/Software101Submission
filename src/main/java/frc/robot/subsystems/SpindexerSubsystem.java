// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpindexerSubsystem extends SubsystemBase {

 

  VelocityVoltage req = new VelocityVoltage(0);


  TalonFX spindexerMotor = new TalonFX(Constants.SPINDEXER_MOTOR_ID);
  /** Creates a new Arm_Subsystem. */
  public SpindexerSubsystem() {
    TalonFXConfiguration cfg = new TalonFXConfiguration()
    .withCurrentLimits(new CurrentLimitsConfigs()
    .withSupplyCurrentLimit(60)
    .withSupplyCurrentLimitEnable(true)
    .withStatorCurrentLimit(80)
    .withStatorCurrentLimitEnable(true));

  
    cfg.Slot0.kV = 1;
    cfg.Feedback.SensorToMechanismRatio = 8.75;
    spindexerMotor.getConfigurator().apply(cfg);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setVelocity(double vel) {
      spindexerMotor.setControl(req.withVelocity(vel));

  }
}