package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    private final TalonFX intakeMotor = new TalonFX(IntakeConstants.MotorID);
    private final PositionVoltage request = new PositionVoltage(0);

    public Intake() {
        TalonFXConfiguration cfg = new TalonFXConfiguration();
        cfg.Slot0.kP = IntakeConstants.KP;
        cfg.Slot0.kG = IntakeConstants.KG;
        cfg.Feedback.SensorToMechanismRatio = IntakeConstants.GearRatio;
        cfg.CurrentLimits.StatorCurrentLimit = IntakeConstants.statorlimit;
        cfg.CurrentLimits.StatorCurrentLimitEnable = true;
        cfg.CurrentLimits.SupplyCurrentLimit = IntakeConstants.supplylimit;
        cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
        cfg.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        cfg.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    }
    public void goToPosition (double rotations) {
        intakeMotor.setControl(request.withPosition(rotations));
    }
}

