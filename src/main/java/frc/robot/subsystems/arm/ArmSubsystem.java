package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
    private final TalonFX armMotor =
     new TalonFX(6);
    private final PositionVoltage request =
     new PositionVoltage(0);


public ArmSubsystem() {
    var cfg = new TalonFXConfiguration();
    cfg.Slot0.GravityType=GravityTypeValue.Arm_Cosine;
    cfg.Slot0.kP = 55;
    cfg.Slot0.kG = 0.4; 
    cfg.CurrentLimits.SupplyCurrentLimit = 20.0;
    cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
    cfg.CurrentLimits.StatorCurrentLimit = 80.0;
    cfg.CurrentLimits.StatorCurrentLimitEnable = true;
    cfg.MotorOutput.NeutralMode = com.ctre.phoenix6.signals.NeutralModeValue.Coast;
    cfg.Feedback.SensorToMechanismRatio = 36;
    armMotor.getConfigurator() .apply(cfg);

    }
    public void goToPosition (double rotations) {
        armMotor.setControl (
            request.withPosition (rotations));
    }
}