// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import static frc.robot.Constants.ArmConstants.*;

import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;  

public class ArmSubsystem extends SubsystemBase {
  /** Creates a new ArmSubsystem. */
  private final TalonFX armMotor = new TalonFX(ARM_MOTOR_ID);
  private final PositionVoltage armPosition = new PositionVoltage(0.0).withSlot(0);
  private PositionVoltage currentPosition = armPosition;

  public ArmSubsystem() {
    TalonFXConfiguration armConfig = new TalonFXConfiguration();
    armConfig.CurrentLimits.SupplyCurrentLimit = ARM_MOTOR_SUPPLY_CURRENT_LIMIT;
    armConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
    armConfig.CurrentLimits.StatorCurrentLimit = ARM_MOTOR_STATOR_CURRENT_LIMIT;
    armConfig.CurrentLimits.StatorCurrentLimitEnable = true;
    armConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    armConfig.Feedback.SensorToMechanismRatio = 24.0;


    var slot0Configs = new Slot0Configs();
    slot0Configs.kP = ARM_MOTOR_KP;
    slot0Configs.kI = ARM_MOTOR_KI;
    slot0Configs.kD = ARM_MOTOR_KD;

    armMotor.getConfigurator().apply(armConfig);
    armMotor.getConfigurator().apply(slot0Configs);
  }

    public void goToPosition(double rotations) {
    armMotor.setControl(
      currentPosition.withPosition(rotations));
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}