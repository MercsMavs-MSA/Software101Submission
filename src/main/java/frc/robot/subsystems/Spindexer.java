package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Spindexer extends SubsystemBase {
    private final TalonFX spindexerMotor =
        new TalonFX(IntakeConstants.SPINNDEXER_MOTOR_ID);
    private final VelocityVoltage request =
        new VelocityVoltage(0);

  public Spindexer() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.Slot0.kV = IntakeConstants.SPINNDEXER_KV;
    config.Feedback.SensorToMechanismRatio = IntakeConstants.RATIO;
    config.CurrentLimits.StatorCurrentLimit = IntakeConstants.STATOR_LIMIT;
    config.CurrentLimits.StatorCurrentLimitEnable = true;
    config.CurrentLimits.SupplyCurrentLimit = IntakeConstants.SUPPLY_LIMIT;
    config.CurrentLimits.SupplyCurrentLimitEnable = true;
    spindexerMotor.getConfigurator().apply(config);
  }

  public void goToVelocity(double velocityPerSecond) {
    spindexerMotor.setControl(
        request.withVelocity (velocityPerSecond));
  }
    
}
