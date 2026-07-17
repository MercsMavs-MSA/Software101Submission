// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import java.io.ObjectInputFilter.Config;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor =
      new TalonFX(ArmConstants.ARM_MOTOR_ID);
  private final PositionVoltage request =
      new PositionVoltage(0);
 
  public ArmSubsystem() {
    var cfg = new TalonFXConfiguration();
    cfg.Slot0.kP = ArmConstants.kP;  // tuning
    cfg.Slot0.kD = ArmConstants.kD;
    cfg.Slot0.kG = ArmConstants.kG;  // hold vs gravity
    
    cfg.Slot0.GravityType = GravityTypeValue.Arm_Cosine;


    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.CurrentLimits.StatorCurrentLimit = ArmConstants.ARM_STATOR_LIMIT;

    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
    cfg.CurrentLimits.SupplyCurrentLimit = ArmConstants.ARM_SUPPLY_LIMIT;

    cfg.Feedback.SensorToMechanismRatio = ArmConstants.ARM_GEAR_RATIO;

    armMotor.getConfigurator().apply(cfg);
  }
 
  public void goToPosition(double rotations) {
    armMotor.setControl(
        request.withPosition(rotations));
  }
}
