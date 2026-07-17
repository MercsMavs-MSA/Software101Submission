// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpindexerSubsystem extends SubsystemBase {
  private TalonFX spindexerMotor = new TalonFX(SpindexerConstants.SPINDEXER_MOTOR_ID);

  private final VelocityVoltage request = new VelocityVoltage(0.0);

  /** Creates a new SpindexerSubsystem. */
  public SpindexerSubsystem() {
    TalonFXConfiguration spindexerConfiguration = new TalonFXConfiguration();
    spindexerConfiguration.Slot0.kV = SpindexerConstants.SPINDEXER_KV;
    spindexerConfiguration.Feedback.SensorToMechanismRatio = SpindexerConstants.GEAR_RATIO;
    spindexerConfiguration.CurrentLimits.StatorCurrentLimit = SpindexerConstants.STATOR_LIMIT;
    spindexerConfiguration.CurrentLimits.SupplyCurrentLimit = SpindexerConstants.SUPPLY_LIMIT;
    spindexerConfiguration.CurrentLimits.StatorCurrentLimitEnable = true;
    spindexerConfiguration.CurrentLimits.SupplyCurrentLimitEnable = true;
    spindexerConfiguration.MotorOutput.Inverted = SpindexerConstants.INVERTED;
    spindexerMotor.getConfigurator().apply(spindexerConfiguration);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void run(double rps) {
    spindexerMotor.setControl(request.withVelocity(rps));
  }

  public void stop() {
    spindexerMotor.stopMotor();
  }
}
