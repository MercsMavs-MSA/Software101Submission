// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration; 
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import static edu.wpi.first.units.Units.Amps;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class VelocityIntakeSubsystem extends SubsystemBase {
  /** Creates a new VelocityIntakeSubsystem. */
  private final TalonFX velocityMotor =
  new TalonFX(42); 
  private final VelocityVoltage request =
      new VelocityVoltage(0); 

  public VelocityIntakeSubsystem() {

    
    
  

 
    var cfg = new TalonFXConfiguration(); //Changed
    cfg.Slot0.kP = 0.2;  // from tuning
    cfg.Slot0.kV = 0.215; 

    // Set the SensorToMechanismRatio to your gear ratio (e.g., 10.0)
    cfg.Feedback.SensorToMechanismRatio = 1.666;
    cfg.CurrentLimits.StatorCurrentLimit = 50.0;
    cfg.CurrentLimits.SupplyCurrentLimit= 30.0;
    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;   

    velocityMotor.getConfigurator().apply(cfg);
  }
  
  public void setVelocity(double velocity) {
    velocityMotor.setControl(
        request.withVelocity(velocity));
  }
  
  public void stop(){  //A way to slow down the motors and hit 0
    setVelocity(0);
  }



  @Override
  public void periodic() {


  }
}

