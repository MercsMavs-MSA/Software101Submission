package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

// this is the arm class
public class ArmSubsystem extends SubsystemBase {
// the motor we use for spinning the arm
private final TalonFX armMotor = new TalonFX(Constants.ARM_MOTOR_ID);
private final PositionVoltage positionRequest = new PositionVoltage(0).withSlot(0);

  public ArmSubsystem() {
    // setup the pid gains
    Slot0Configs slot0Configs = new Slot0Configs();
    slot0Configs.kP = Constants.ARM_KP;
    slot0Configs.kI = Constants.ARM_KI;
    slot0Configs.kD = Constants.ARM_KD;
    armMotor.getConfigurator().apply(slot0Configs);

    // current limit so it dont break
    CurrentLimitsConfigs currentLimits = new CurrentLimitsConfigs();
    currentLimits.StatorCurrentLimit = Constants.ARM_STATOR_CURRENT_LIMIT;
    currentLimits.StatorCurrentLimitEnable = true;
    currentLimits.SupplyCurrentLimit = Constants.ARM_SUPPLY_CURRENT_LIMIT;
    currentLimits.SupplyCurrentLimitEnable = true;
    armMotor.getConfigurator().apply(currentLimits);
  }

  // moves the arm too the position
  public void goToPosition(double rotations) {
  // tell motor were to go
    armMotor.setControl(positionRequest.withPosition(rotations));
  }
}
