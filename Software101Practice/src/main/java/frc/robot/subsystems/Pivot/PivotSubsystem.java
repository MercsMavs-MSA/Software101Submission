// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Pivot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PivotSubsystem extends SubsystemBase {
  /** Creates a new PivotSubsystem. */

  private final TalonFX pivotMotor = new TalonFX(PivotConstants.PIVOT_MOTOR_ID);
  private final PositionVoltage request = new PositionVoltage(0);


    public PivotSubsystem()
    {
      

      var talonFXConfigs = new TalonFXConfiguration();
      
      talonFXConfigs.Slot0.kP = PivotConstants.PIVOT_KP;
      talonFXConfigs.Slot0.kD = PivotConstants.PIVOT_KD;
      talonFXConfigs.Slot0.kG = PivotConstants.PIVOT_KG;
      
      talonFXConfigs.CurrentLimits.StatorCurrentLimit = PivotConstants.PIVOT_STATOR;
      talonFXConfigs.CurrentLimits.StatorCurrentLimitEnable = true;

      talonFXConfigs.CurrentLimits.SupplyCurrentLimit = PivotConstants.PIVOT_SUPPLY;
      talonFXConfigs.CurrentLimits.SupplyCurrentLimitEnable = true;

      talonFXConfigs.Feedback.SensorToMechanismRatio = PivotConstants.PIVOT_GEAR_RATIO;
      talonFXConfigs.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;



      pivotMotor.getConfigurator().apply(talonFXConfigs);

    }

    public void goToPosition(double rotations)
    {
      pivotMotor.setControl(request.withPosition(rotations));

    }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
