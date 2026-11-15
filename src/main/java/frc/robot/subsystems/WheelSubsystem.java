package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WheelSubsystem extends SubsystemBase {
    private final TalonFX wheelMotor = new TalonFX(43);
    private final VelocityVoltage request = new VelocityVoltage(0);

    public WheelSubsystem() {
        TalonFXConfiguration config = new TalonFXConfiguration();

        // I was told to find the new constants in google slides but I wasn't able to find it even after searching for a while so I decided to just keep it as this.
        config.Slot0.kP = 0;
        config.Slot0.kI = 0;
        config.Slot0.kD = 0;
        config.Slot0.kV = 0;

        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.CurrentLimits.SupplyCurrentLimitEnable = true;
        config.CurrentLimits.StatorCurrentLimit = 80;
        config.CurrentLimits.SupplyCurrentLimit = 60;
        config.Feedback.SensorToMechanismRatio = Constants.SPINDEXER_GEAR_RATIO;

        wheelMotor.getConfigurator().apply(config);
    }
    public void goToVelocity(double velocity) {
        wheelMotor.setControl(request.withVelocity(velocity));
    }
}

