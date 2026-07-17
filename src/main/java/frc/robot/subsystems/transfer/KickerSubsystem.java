package frc.robot.subsystems.transfer;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.VelocityUnit;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/* 
gear ratio (insert 5.0 / 1.0) - because double formatting
current limit of both stator and supply
pid and feedforward values need to be inputted9
*/
public class KickerSubsystem extends SubsystemBase {
  private final TalonFX kickerMotor = new TalonFX(TransferConstants.KICKER_MOTOR_ID);
  private final VelocityVoltage request = new VelocityVoltage(0);
 
  public KickerSubsystem() {
    TalonFXConfiguration config = new TalonFXConfiguration();

    config.CurrentLimits.StatorCurrentLimit = 60.0;
    config.CurrentLimits.SupplyCurrentLimit = 30.0;
    config.CurrentLimits.SupplyCurrentLimitEnable = true;
    config.CurrentLimits.StatorCurrentLimitEnable = true;

    config.Feedback.SensorToMechanismRatio = TransferConstants.KICKER_GEAR_RATIO;
    var talonFXConfig = new TalonFXConfiguration();
    talonFXConfig.Slot0.kV = TransferConstants.KICKER_KV;
    talonFXConfig.Slot0.kS = TransferConstants.KICKER_KS;
    
    kickerMotor.getConfigurator().apply(talonFXConfig);
  }
 
  public void goToVelocity(double velocity) {
    kickerMotor.setControl(
        request.withVelocity(velocity));
  }
}