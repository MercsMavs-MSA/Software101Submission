package frc.robot.subsystems.Wheel;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WheelSubsystem extends SubsystemBase { // It didn't extend subsystem base why
    //TODO: FIX MOTOR ID
    private final TalonFX wheelMotor = new TalonFX(Constants.WHEEL_MOTOR_ID);

    private final VelocityVoltage request = new VelocityVoltage(0);

    public WheelSubsystem()
    {
        TalonFXConfiguration cfg = new TalonFXConfiguration();
        cfg.Slot0.kV = 0;
        cfg.Slot0.kP = 0;
        cfg.CurrentLimits.StatorCurrentLimit = 60;
        cfg.CurrentLimits.StatorCurrentLimitEnable = true;
        wheelMotor.getConfigurator().apply(cfg);
    }

    /**
     * Set velocity of the wheelMotor
     * @param rps Desired velocity in rotations per second
     */
    public void setVelocity(double rps)
    {
        wheelMotor.setControl(request.withVelocity(rps));
    }
}
