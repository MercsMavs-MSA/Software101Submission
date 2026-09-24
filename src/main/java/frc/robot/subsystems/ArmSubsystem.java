// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  private TalonFX intakePivot;
  private PositionVoltage request = new PositionVoltage(0);
  public ArmSubsystem() {
    intakePivot = new TalonFX(42);//20
    TalonFXConfiguration cfg = new TalonFXConfiguration();

    cfg.Slot0.kP = Constants.kP;
    cfg.Slot0.kV = Constants.kV;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = Constants.currLimEnable;
    cfg.CurrentLimits.SupplyCurrentLimit = Constants.currentLimit;
    cfg.CurrentLimits.StatorCurrentLimitEnable = Constants.statLimEnable;
    cfg.CurrentLimits.StatorCurrentLimit = Constants.statorLimit;
    cfg.MotorOutput.NeutralMode = Constants.NeutralMode;
    cfg.Feedback.SensorToMechanismRatio = Constants.gearRatio;
    intakePivot.getConfigurator().apply(cfg);
  }

  public void goToPosition(double rotations) {
      intakePivot.setControl(request.withPosition(rotations));
  }

public Object setPosition(double d) {
    throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
}
}
