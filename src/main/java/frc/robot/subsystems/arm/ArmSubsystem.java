// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.*;
import com.ctre.phoenix6.controls.*;
import com.ctre.phoenix6.hardware.*;
import com.ctre.phoenix6.signals.GravityTypeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
  //initializing motors
  private final TalonFX armMotor = new TalonFX(ArmConstants.MOTOR_ID);
  private final PositionVoltage request = new PositionVoltage(0);


  public ArmSubsystem() {
    TalonFXConfiguration config = new TalonFXConfiguration();

    //PID + Feedforward
    config.Slot0.kP = ArmConstants.KP;
    config.Slot0.kD = ArmConstants.KD;
    config.Slot0.kG = ArmConstants.KG;
    
    //Current Limits
    config.CurrentLimits.StatorCurrentLimitEnable = true;
    config.CurrentLimits.SupplyCurrentLimitEnable = true;
    config.CurrentLimits.StatorCurrentLimit = ArmConstants.MAX_STATOR_CURRENT;
    config.CurrentLimits.SupplyCurrentLimit = ArmConstants.MAX_SUPPLY_CURRENT;

    //MISC
    config.Feedback.SensorToMechanismRatio = ArmConstants.GEAR_RATIO;
    config.Slot0.GravityType = GravityTypeValue.Arm_Cosine;

    armMotor.getConfigurator().apply(config);
  }

  public void goToPosition(double rotations) {
    armMotor.setControl(request.withPosition(rotations));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
