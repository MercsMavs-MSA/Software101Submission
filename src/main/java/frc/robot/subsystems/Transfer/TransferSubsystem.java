// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Transfer;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

public class TransferSubsystem extends SubsystemBase {
  /** Creates a new TransformerSubsystem. */
  private final TalonFX transferMotor = new TalonFX(TransferConstants.TRANSFER_MOTOR_ID);
      private final VelocityVoltage request = new VelocityVoltage(0);  
  public TransferSubsystem() {
      var cfg = new TalonFXConfiguration();
      cfg.Feedback.RotorToSensorRatio = TransferConstants.GEAR_RATIO;
      cfg.Slot0.kP = TransferConstants.kP;
      cfg.Slot0.kV = TransferConstants.kV;
      cfg.CurrentLimits.StatorCurrentLimitEnable = true;
      cfg.CurrentLimits.StatorCurrentLimit = TransferConstants.Stator_Limiter;
      cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
      cfg.CurrentLimits.SupplyCurrentLimit = TransferConstants.Supply_Limiter;

      transferMotor.getConfigurator().apply(cfg);
  }

  public void runTransfer(double velocity) {
    transferMotor.setControl(request.withVelocity(velocity));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
