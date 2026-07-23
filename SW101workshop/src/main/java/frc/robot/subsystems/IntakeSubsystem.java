package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final TalonFX intakeMoter = new TalonFX(IntakeConstraints.INTAKE_MOTER_ID);
    private final PositionVoltage request = new PositionVoltage(0);

    public IntakeSubsystem()
    {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.Slot0.kP = IntakeConstraints.KP;
        // config.Slot0.kD = IntakeConstraints.KD;
        // config.Slot0.kG = IntakeConstraints.KG;
        config.Feedback.SensorToMechanismRatio = IntakeConstraints.RATIO;

        config.CurrentLimits.StatorCurrentLimit = IntakeConstraints.STATOR_LIMIT;
        config.CurrentLimits.SupplyCurrentLimit = IntakeConstraints.SUPPLY_LIMIT;

        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.CurrentLimits.SupplyCurrentLimitEnable = true;

        intakeMoter.getConfigurator().apply(config);
    }

    public void goToPosition(double rotations) {
        intakeMoter.setControl(
            request.withPosition(rotations)
        );
    }
}