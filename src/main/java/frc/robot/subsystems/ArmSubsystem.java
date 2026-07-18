package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;

public class ArmSubsystem implements Subsystem {
    TalonFXConfiguration motorConfig;
    TalonFX motor;

    PositionVoltage control;

    public ArmSubsystem() {
        motor = new TalonFX(Constants.ArmConstants.kArmMotorId);
        motorConfig = new TalonFXConfiguration();
        
        motorConfig.Slot0.kP = Constants.ArmConstants.kP;
        motorConfig.Slot0.kD = Constants.ArmConstants.kD;
        motorConfig.Slot0.kG = Constants.ArmConstants.kG;
        motorConfig.Feedback.RotorToSensorRatio = Constants.ArmConstants.kRotorToSensor;
        motorConfig.MotorOutput.Inverted = Constants.ArmConstants.kInvert;
        
        motor.getConfigurator().apply(motorConfig);

        control.Position = Constants.ArmConstants.kArmStowSetpoint;
        motor.setControl(control);
    }

    public Command armOut() {
        return Commands.runOnce(() -> {
            control.Position = Constants.ArmConstants.kArmOutSetpoint;
            motor.setControl(control);
        }, this);
    }

    public Command armIn() {
        return Commands.runOnce(() -> {
            control.Position = Constants.ArmConstants.kArmInSetpoint;
            motor.setControl(control);
        }, this);
    }
}
