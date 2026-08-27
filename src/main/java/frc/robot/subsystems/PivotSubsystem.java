package frc.robot.subsystems;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public final class PivotSubsystem extends SubsystemBase {
  //device id not set - placeholder
  private final TalonFX pivotMotor = new TalonFX(42);
  //placeholder
  private final PositionVoltage positionRequest = new PositionVoltage(0);
  public PivotSubsystem() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    //gear ratio - Feedback
    config.Feedback.SensorToMechanismRatio = 24.0;
    //TODO: PID - place holder values
    config.Slot0.kP = 25.0;
    config.Slot0.kG = 0;
    config.Slot0.kV = 0;
    config.Slot0.kI = 0;
    //current limits - placeholer values
    config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    config.MotorOutput.NeutralMode = NeutralModeValue.Coast;
    config.CurrentLimits.StatorCurrentLimitEnable = true;
    config.CurrentLimits.SupplyCurrentLimitEnable = true;
    config.CurrentLimits.StatorCurrentLimit = 60;
    config.CurrentLimits.SupplyCurrentLimit = 50;
    

    pivotMotor.getConfigurator().apply(config);
  }
  public void goToPosition(double rotations) {
    pivotMotor.setControl(positionRequest.withPosition(rotations));

  }
  
}



