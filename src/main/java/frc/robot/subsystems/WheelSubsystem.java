package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WheelSubsystem extends SubsystemBase {
  private final TalonFX wheelMotor =
    new TalonFX (Constants.WHEEL_MOTOR_ID);
  private final VelocityVoltage request = 
    new VelocityVoltage (0);

  public WheelSubsystem() {
    var cfg = new TalonFXConfiguration();

    cfg.Slot0.kV = Constants.WHEEL_KV;
    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.CurrentLimits.StatorCurrentLimit = 80;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
    cfg.CurrentLimits.SupplyCurrentLimit = 60;
    cfg.Feedback.SensorToMechanismRatio = 8.75;
    wheelMotor.getConfigurator().apply(cfg);
  }

  public void goToVelocity (double rotations) {
    wheelMotor.setControl (
      request.withVelocity(rotations));
  }
}