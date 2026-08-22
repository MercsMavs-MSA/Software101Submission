package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelSubsystem extends SubsystemBase {
    
    private final TalonFX wheelMotor = new TalonFX(43); 
    private final VelocityVoltage velocityRequest = new VelocityVoltage(0);

    public WheelSubsystem() {
        
        TalonFXConfiguration wheelConfig = new TalonFXConfiguration();
        
        wheelConfig.Feedback.SensorToMechanismRatio = 5.0 * (30.0 / 18);
        wheelConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        wheelConfig.CurrentLimits.StatorCurrentLimit = 75;
        wheelConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
        wheelConfig.CurrentLimits.SupplyCurrentLimit = 65;
        wheelConfig.Slot0.kV = 1.05;

        wheelMotor.getConfigurator().apply(wheelConfig);
    }

    public void setVelocity(double velocity) {
        velocityRequest.Velocity = velocity;
        wheelMotor.setControl(velocityRequest);
    }
}
