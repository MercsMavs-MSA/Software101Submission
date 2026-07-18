// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.IntakeRollers;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeRollersSubsystem extends SubsystemBase {
  /** Creates a new IntakeRollersSubsystem. */
  private final TalonFX rollerMotor = new TalonFX(IntakeRollersConstants.ROLLERS_MOTOR_ID);
  private final VelocityVoltage request = new VelocityVoltage(0);

  public IntakeRollersSubsystem() {

    TalonFXConfiguration config = new TalonFXConfiguration();

    config.CurrentLimits.StatorCurrentLimit = IntakeRollersConstants.ROLLER_STATOR;
    config.CurrentLimits.SupplyCurrentLimit = IntakeRollersConstants.ROLLER_SUPPLY;
    config.CurrentLimits.StatorCurrentLimitEnable = true;
    config.CurrentLimits.SupplyCurrentLimitEnable = true;


    config.Feedback.SensorToMechanismRatio = IntakeRollersConstants.ROLLER_GEAR_RATIO;
    var talonConfig = new TalonFXConfiguration();
    talonConfig.Slot0.kV = IntakeRollersConstants.ROLLERS_KV;
    talonConfig.Slot0.kS = IntakeRollersConstants.ROLLERS_KS;

    rollerMotor.getConfigurator().apply(talonConfig);

  }

  public void goToVelocity(double velocity)
  {
    rollerMotor.setControl(request.withVelocity(velocity));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
