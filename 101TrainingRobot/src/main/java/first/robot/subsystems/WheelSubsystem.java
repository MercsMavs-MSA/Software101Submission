package first.robot.subsystems;

import org.wpilib.command2.SubsystemBase;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import first.robot.Constants;

public class WheelSubsystem extends SubsystemBase {
  private final TalonFX wheelMotor = new TalonFX(Constants.WHEEL_MOTOR_ID, null);
  private final VelocityVoltage request = new VelocityVoltage(0);
 
  public WheelSubsystem() {
    var cfg = new TalonFXConfiguration();
    cfg.Slot0.kP = Constants.WHEEL_KP;  // from tuning
    cfg.Slot0.kD = Constants.WHEEL_KD;
    cfg.Slot0.kI = Constants.WHEEL_KI;
    cfg.Slot0.kS = Constants.WHEEL_FEEDFORWARD[0]; // static friction  
    cfg.Slot0.kV = Constants.WHEEL_FEEDFORWARD[1]; // Constant vel
    cfg.Slot0.kA = Constants.WHEEL_FEEDFORWARD[2]; // target accel

    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
    cfg.CurrentLimits.StatorCurrentLimit = 80;
    cfg.CurrentLimits.SupplyCurrentLimit = 60;
    cfg.Feedback.SensorToMechanismRatio =    Constants.SPINDEXER_GEAR_RATIO;

    wheelMotor.getConfigurator().apply(cfg);
  }
 
  public void setVelocity(double velocity) {
    wheelMotor.setControl(
        request.withVelocity(velocity));
  }
}
