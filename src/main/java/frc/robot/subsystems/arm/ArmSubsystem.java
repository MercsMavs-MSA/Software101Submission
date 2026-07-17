package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor = new TalonFX(ArmConstants.OperatorConstants.ARM_MOTOR_ID);
  private final PositionVoltage request = new PositionVoltage(0);
  private final NeutralOut m_brake = new NeutralOut();
  public ArmSubsystem() {
    TalonFXConfiguration configs = new TalonFXConfiguration();
    configs.Slot0.kP = ArmConstants.OperatorConstants.ARM_KP;
    configs.Slot0.kD = ArmConstants.OperatorConstants.ARM_KD;
    configs.Slot0.kG = ArmConstants.OperatorConstants.ARM_KG;
    configs.Feedback.SensorToMechanismRatio = 110.0;
    configs.CurrentLimits.StatorCurrentLimit = 0; //CHANGE THIS
    configs.CurrentLimits.SupplyCurrentLimit = 0; //CHANGE THIS
    configs.CurrentLimits.SupplyCurrentLimitEnable = true;
    configs.CurrentLimits.StatorCurrentLimitEnable = true;
    armMotor.getConfigurator().apply(configs);
  }

  public void goToPosition(double position) {
    armMotor.setControl(request.withPosition(position));
  }
}