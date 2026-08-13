// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {

  private TalonFX intakePivot;
  private final PositionVoltage request = new PositionVoltage(0);
  /** Creates a new ArmSubsystem. */
    public ArmSubsystem() {
    intakePivot = new TalonFX(42); //TODO: CHANGE ID TO CORRECT ONE
    TalonFXConfiguration cf1 = new TalonFXConfiguration();
    cf1.Slot0.kP = 25;
    cf1.Slot0.kV = 0;
    cf1.Slot0.kA = 0;
    cf1.Slot0.kI = 0;
    cf1.Slot0.kD = 0;
    cf1.Slot0.kG = 0;
    cf1.Slot0.kS = 0;
    cf1.CurrentLimits.SupplyCurrentLimitEnable = true;
    cf1.CurrentLimits.SupplyCurrentLimit = 50;
    cf1.Feedback.SensorToMechanismRatio = 24.0 / 1.0;
    cf1.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    cf1.CurrentLimits.SupplyCurrentLimitEnable = true;
    cf1.CurrentLimits.StatorCurrentLimit = 60;
    cf1.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    intakePivot.getConfigurator().apply(cf1);
  }

  public void goToPosition(double rotations) {
    intakePivot.setControl(request.withPosition(rotations));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
