package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpindexerSubsystem extends SubsystemBase {
    private final TalonFX spindexerMotor = new TalonFX(Constants.SPINDEXER_MOTOR_ID);
    private final VelocityVoltage request = new VelocityVoltage(0);

    public SpindexerSubsystem() {
        var config = new TalonFXConfiguration();

        config.Slot0.kP = Constants.SPINDEXER_KP;
        config.Slot0.kD = Constants.SPINDEXER_KD;
        config.Slot0.kG = Constants.SPINDEXER_KG;
        
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.CurrentLimits.SupplyCurrentLimitEnable = true;
        config.CurrentLimits.StatorCurrentLimit = 80;
        config.CurrentLimits.StatorCurrentLimit = 60;

        config.Feedback.SensorToMechanismRatio = Constants.SPINDEXER_GEAR_RATIO;

        spindexerMotor.getConfigurator().apply(config);
    }

    public void setVelocity(double velocity) {
        spindexerMotor.setControl(request.withVelocity(velocity));
    }
}
