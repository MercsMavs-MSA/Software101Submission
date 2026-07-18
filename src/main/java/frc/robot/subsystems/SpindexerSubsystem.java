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

  TalonFXConfiguration cfg = new TalonFXConfiguration()
  .withCurrentLimits(new CurrentLimitsConfigs()
  .withStatorCurrentLimit(120)
  .withStatorCurrentLimitEnable(true));

  VelocityVoltage req = new VelocityVoltage(0);


  TalonFX SpindexerMotor = new TalonFX(Constants.SPINDEXER_MOTOR_ID);
  /** Creates a new Arm_Subsystem. */
  public SpindexerSubsystem() {
    cfg.Slot0.kP = 0;
    cfg.Slot0.kI = 0;
    cfg.Slot0.kD = 0;
    cfg.Slot0.kV = 1;
    cfg.Feedback.SensorToMechanismRatio = 1;
    SpindexerMotor.getConfigurator().apply(cfg);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setVelocity(double vel) {
      SpindexerMotor.setControl(req.withVelocity(10));

  }
}
