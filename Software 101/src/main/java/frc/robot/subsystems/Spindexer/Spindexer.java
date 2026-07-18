// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Spindexer;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import javax.print.attribute.standard.RequestingUserName;
import javax.security.auth.login.ConfigurationSpi;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class Spindexer extends SubsystemBase {
  private final TalonFX SpindexerMotor = new TalonFX(11); //TODO: CHANGE ID TO WHAT IT NEEDS TO BE
  private final PositionVoltage request = new VeolocityVoltage(Velocity:0)
 
  public Spindexer() {
    TalonFXConfiguration crg = new TalonFXConfiguration();
    
    config.CurrentLimits.StatorCurrentLimit = 60.0;
    config.CurrentLimits.StatorCurrentLimitEnable = true;
    
    config.CurrentLimits.SupplyCurrentLimit = 30.0;
    config.CurrentLimits.SupplyCurrentLimitEnable = true;
    
    config.Feedback.SensorToMechanismRatio = TransferConstants.SPINDEXER_GEAR_RATIO;

    

    crg.Slot0.kV = SpindexerConstants.SPINDEXER_KV;  // from tuning |What's the issue?
    crg.Slot0.kP = SpindexerConstants.SPINDEXER_KP;
    
    
    SpindexerMotor.getConfigurator().apply(crg); //csg
  }

  public void setPosition(double rotations){
    SpindexerMotor.setControl(request.withPosition(7));

  }
}