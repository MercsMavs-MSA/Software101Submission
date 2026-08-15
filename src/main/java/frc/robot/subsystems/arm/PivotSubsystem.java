package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PivotSubsystem extends SubsystemBase {
  
  private final TalonFX pivotMotor = new TalonFX(PivotConstants.OperatorConstants.PIVOT_MOTOR_ID);
  private final PositionVoltage request = new PositionVoltage(0);
    
  public PivotSubsystem() {
    TalonFXConfiguration configs = new TalonFXConfiguration();
    configs.Slot0.kP = PivotConstants.OperatorConstants.PIVOT_KP;
    configs.Slot0.kD = PivotConstants.OperatorConstants.PIVOT_KD;
    configs.Slot0.kG = PivotConstants.OperatorConstants.PIVOT_KG;
    configs.Feedback.SensorToMechanismRatio = 110.0; //gear ratio
    configs.CurrentLimits.StatorCurrentLimit = PivotConstants.OperatorConstants.PIVOT_STATOR;
    configs.CurrentLimits.SupplyCurrentLimit = PivotConstants.OperatorConstants.PIVOT_SUPPLY;
    configs.CurrentLimits.SupplyCurrentLimitEnable = true; //what is supplied to the motor
    configs.CurrentLimits.StatorCurrentLimitEnable = true; //what the motor actually uses
    pivotMotor.getConfigurator().apply(configs);
  }

  public void goToPosition(double position) {
    pivotMotor.setControl(request.withPosition(position));
  }

}