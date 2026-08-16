package frc.robot.subsystems;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfigurator;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Spindexer extends SubsystemBase {

    private final TalonFX SpindexerMotor = new TalonFX(Constants.SPINDEXER_MOTOR_ID);

    TalonFXConfiguration configs = new TalonFXConfiguration()
    .withCurrentLimits(new CurrentLimitsConfigs()
    .withStatorCurrentLimit(80)
    .withStatorCurrentLimitEnable(true));

    VelocityVoltage request = new VelocityVoltage(0);


    public Spindexer() {
        configs.Slot0.kP = 0.1;
        configs.Slot0.kI = 0;
        configs.Slot0.kD = 0;
        configs.Slot0.kV = 1.0; 
        configs.Feedback.SensorToMechanismRatio = 10.0;
        SpindexerMotor.getConfigurator().apply(configs);
    }

    public void setVelocity(double velocity) {
        SpindexerMotor.setControl(request.withVelocity(velocity));
    }

    public void periodic() {}
}
