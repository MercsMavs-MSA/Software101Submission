package frc.robot.subsystem.Wheel;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Constants;

public class WheelSubsystem {
    private final TalonFX wheelMotor = new TalonFX(Constants.WHEEL_MOTOR_ID);

    private final VelocityVoltage request = new VelocityVoltage(0);

    public WheelSubsystem()
    {
        TalonFXConfiguration cfg = new TalonFXConfiguration();
        cfg.Slot0.kV = 0;
        cfg.Slot0.kP = 0;
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.CurrentLimits.SupplyCurrentLimitEnable = true;
        config.CurrentLimits.StatorCurrentLimit = 80;
        config.CurrentLimits.SupplyCurrentLimit = 60;
        config.Feedback.SensorToMechanismRatio =    Constants.SPINDEXER_GEAR_RATIO;
        wheelMotor.getConfigurator().apply(cfg);
    }

    public void setVelocity(double rps)
    {
        wheelMotor.setControl(request.withVelocity(rps));
    }
    /**
     * Set velocity of the wheelMotor
     * @param rps Desired velocity in rotations per second.
     */
    public double getVelocity()
    {
        return wheelMotor.getVelocity().getValueAsDouble();
    }
}