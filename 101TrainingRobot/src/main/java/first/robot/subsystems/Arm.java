package first.robot.subsystems;

import org.wpilib.command2.SubsystemBase;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import first.robot.Constants;

public class Arm extends SubsystemBase {
  private final TalonFX armMotor = new TalonFX(Constants.ARM_MOTOR_ID, null);
  private final PositionVoltage request = new PositionVoltage(0);
 
  public Arm() {
    var cfg = new TalonFXConfiguration();
    cfg.Slot0.kP = Constants.ARM_KP;  // from tuning
    cfg.Slot0.kD = Constants.ARM_KD;
    cfg.Slot0.kG = Constants.ARM_FEEDFORWARD[3];  // hold vs gravity
    armMotor.getConfigurator().apply(cfg);
  }
 
  public void goToPosition(double rotations) {
    armMotor.setControl(
        request.withPosition(rotations));
  }
}
