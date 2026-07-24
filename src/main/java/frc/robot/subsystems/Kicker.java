package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Kicker extends SubsystemBase{

    private final TalonFX kickerMotor = 
        new TalonFX(KickerConstants.KICKER_MOTOR_ID);
    private final VelocityVoltage request = 
        new VelocityVoltage(0);

    public Kicker() {
        TalonFXConfiguration cfg = new TalonFXConfiguration();
        cfg.Slot0.kV = KickerConstants.KV; 
        cfg.Feedback.SensorToMechanismRatio = KickerConstants.RATIO; 
        cfg.CurrentLimits.StatorCurrentLimit = KickerConstants.STATOR_LIMIT;
        cfg.CurrentLimits.StatorCurrentLimitEnable = true;
        cfg.CurrentLimits.SupplyCurrentLimit = KickerConstants.SUPPLY_LIMIT;
        cfg.CurrentLimits.SupplyCurrentLimitEnable = true;
        kickerMotor.getConfigurator().apply(cfg); 
    }

     public void goToVelocity(double rotationsPerSecond) {
            kickerMotor.setControl(
                request.withVelocity(rotationsPerSecond));
        }

    

    
}
