package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

import frc.robot.Constants;


public class ArmSubsystem {

    private final TalonFX ArmMotor = new TalonFX(42); 
    private final PositionVoltage request = new PositionVoltage(0); 

    public ArmSubsystem(){ 

        TalonFXConfiguration cfg = new TalonFXConfiguration(); 
        cfg.Slot0.kP = Constants.KP;  
        cfg.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        cfg.Feedback.SensorToMechanismRatio = Constants.GEAR_RATIO;  // stator = 80 supply 60 

        cfg.CurrentLimits.StatorCurrentLimitEnable = true; 
        cfg.CurrentLimits.SupplyCurrentLimitEnable = true; 
        cfg.CurrentLimits.SupplyCurrentLimit = 50; 
        cfg.CurrentLimits.StatorCurrentLimit = 60; 

        ArmMotor.getConfigurator().apply(cfg);

        

    }

    public void goToPosition(double rotations){ 

        ArmMotor.setControl(request.withPosition(rotations));

    }
    
}
