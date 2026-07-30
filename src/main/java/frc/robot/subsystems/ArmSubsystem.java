// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

  private TalonFX intakePivot;
  private PositionVoltage request = new PositionVoltage(0);

  /** Creates a new ArmSubsystem. */
  public ArmSubsystem() {
    intakePivot = new TalonFX(42); //TODO: Change device ID
    TalonFXConfiguration cfg  = new TalonFXConfiguration(); 
    
    cfg.Slot0.kP = Constants.intakeKP;
    cfg.Slot0.kV = Constants.intakeKV;

    cfg.CurrentLimits.SupplyCurrentLimit = Constants.currentLimit;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = Constants.currLimEnable;
    cfg.CurrentLimits.StatorCurrentLimit = Constants.statorLimit;
    cfg.CurrentLimits.StatorCurrentLimitEnable = Constants.statorLimEnable;

    cfg.MotorOutput.NeutralMode = Constants.NeutralMode;
    cfg.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    cfg.Feedback.SensorToMechanismRatio = Constants.gearRatio;

    intakePivot.getConfigurator().apply(cfg);
  }

  public void goToPosition(double rotations){
    intakePivot.setControl(request.withPosition(rotations));
  }

  public void goToVelocity(double rpm){
    intakePivot.setControl(request.withVelocity(rpm));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
