package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

//controls velocity of wheel
public class WheelSubsystem extends SubsystemBase {

    private final TalonFX wheelMotor;
    private final VelocityVoltage velocityRequest;

    public WheelSubsystem() {
        wheelMotor = new TalonFX(Constants.WheelConstants.WHEEL_MOTOR_ID);
        //starts velocity control request starting at 0 volts
        velocityRequest = new VelocityVoltage(0);
        //has motor config
        TalonFXConfiguration config = new TalonFXConfiguration();
        
        //configure velocity PID and other constants
        config.Slot0.kV = Constants.WheelConstants.WHEEL_KV;
        config.Slot0.kA = Constants.WheelConstants.WHEEL_KA;
        config.Slot0.kP = Constants.WheelConstants.WHEEL_KP;
        config.Slot0.kI = Constants.WheelConstants.WHEEL_KI;
        config.Slot0.kD = Constants.WheelConstants.WHEEL_KD;
        //Current limits
        config.CurrentLimits.StatorCurrentLimitEnable = true;
        config.CurrentLimits.SupplyCurrentLimitEnable = true;
        config.CurrentLimits.StatorCurrentLimit = 80;
        config.CurrentLimits.SupplyCurrentLimit = 60;
        //wheel gear ratio config
        config.Feedback.SensorToMechanismRatio = Constants.WheelConstants.wheel_gear_ratio;
        //config to motor
        wheelMotor.getConfigurator().apply(config);
    }
    //tells motor to have one set velocity
    public void goToVelocity(double rps) {
        wheelMotor.setControl(velocityRequest.withVelocity(rps));
    }
    //stops wheel mechanism
    public void stop() {
        wheelMotor.setControl(velocityRequest.withVelocity(0));
    }

}
