package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class WheelSubsystem extends SubsystemBase 
{
    private final TalonFX wheelMotor = new TalonFX (43);
    private final VelocityVoltage request = new VelocityVoltage(0);

    public WheelSubsystem()
    {
        TalonFXConfiguration configs = new TalonFXConfiguration();//object
        
        //Configs Kv Curent Limits
        configs.Slot0.kV =1.05;
        configs.CurrentLimits.StatorCurrentLimit=80;
        configs.CurrentLimits.StatorCurrentLimitEnable=true;
        configs.CurrentLimits.SupplyCurrentLimit =60;
        configs.CurrentLimits.StatorCurrentLimitEnable=true;
        configs.Feedback.SensorToMechanismRatio=8.75;

        wheelMotor.getConfigurator().apply(configs);

        

    }
    public void goToVelocity(double velocity)
    {
        wheelMotor.setControl(request.withVelocity(velocity));
    }



    {

    }
    
}
