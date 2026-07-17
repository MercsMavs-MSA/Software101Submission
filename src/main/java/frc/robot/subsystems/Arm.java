package frc.robot.subsystems;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.GravityTypeValue;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class Arm extends SubsystemBase
{

    private final TalonFX armMotor = new TalonFX(34);
    private final PositionVoltage armPositionVoltage = new PositionVoltage(0);

    public Arm()
    {
        final TalonFXConfiguration armConfig = new TalonFXConfiguration();
        armConfig.Slot0.kP = 55;
        armConfig.Slot0.GravityType=GravityTypeValue.Arm_Cosine;
        armConfig.Slot0.kI = 0.0;   
        armConfig.Slot0.kD = 0.0;
        armConfig.CurrentLimits.SupplyCurrentLimit = 20.0;
        armConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
        armConfig.CurrentLimits.StatorCurrentLimit = 80.0;
        armConfig.CurrentLimits.StatorCurrentLimitEnable = true;
        armConfig.MotorOutput.NeutralMode = com.ctre.phoenix6.signals.NeutralModeValue.Coast;
        armConfig.Feedback.SensorToMechanismRatio=36;

        armMotor.getConfigurator().apply(armConfig);

    }
    public void setArmPosition(double position)
    {
         armMotor.setControl(
        armPositionVoltage.withPosition(position));
    }  
}
