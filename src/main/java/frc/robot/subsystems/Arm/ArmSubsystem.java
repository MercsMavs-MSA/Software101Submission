// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor = new TalonFX(Constants.ARM_MOTOR_ID);
  private final PositionVoltage request = new PositionVoltage(0);
 
  public ArmSubsystem() {
    var cfg = new TalonFXConfiguration();
    cfg.Slot0.kP = Constants.ARM_KP;
    cfg.Slot0.kD = Constants.ARM_KD;
    cfg.Slot0.kG = Constants.ARM_KG;
    cfg.Feedback.RotorToSensorRatio = Constants.GEAR_RATIO;
    cfg.CurrentLimits.StatorCurrentLimit = Constants.STATOR_CURRENT_LIMITS;
    cfg.CurrentLimits.SupplyCurrentLimit = Constants.SUPPLY_CURRENT_LIMITS;
    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
    cfg.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    cfg.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    armMotor.getConfigurator().apply(cfg);
  }
 
  public void goToPosition(double rotations) {
    armMotor.setControl(request.withPosition(rotations));
  }
}

