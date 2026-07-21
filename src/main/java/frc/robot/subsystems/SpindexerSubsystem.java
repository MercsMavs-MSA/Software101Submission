package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage; // Changed to Velocity!
import frc.robot.Constants.SpindexerConstants;

public class SpindexerSubsystem extends SubsystemBase {
    private final TalonFX spindexerMotor = new TalonFX(SpindexerConstants.SPINDEXER_MOTOR_ID);
    private final VelocityVoltage velocityRequest = new VelocityVoltage(0);

    public SpindexerSubsystem() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        
=        config.Slot0.kP = SpindexerConstants.SPINDEXER_KP;
        config.Slot0.kD = SpindexerConstants.SPINDEXER_KD;
        config.Slot0.kV = SpindexerConstants.SPINDEXER_KV; 
        
        spindexerMotor.getConfigurator().apply(config);
    }

    /**
     * Drives the spindexer at a target velocity.
     * @param rps Target speed in Rotations Per Second
     */
    public void spinAtVelocity(double rps) {
        spindexerMotor.setControl(velocityRequest.withVelocity(rps));
    }

    @Override
    public void periodic() {}
}
