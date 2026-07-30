package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.ArmSubsystem;

public class TeleopCommands extends Command{
    private ArmSubsystem arm;
    
    public TeleopCommands(ArmSubsystem arm){
        this.arm = arm;
        addRequirements(arm);
    }

   public Command sequential(){

    return Commands.sequence(
        arm.runOnce(() -> arm.goToPosition(0)), 
        Commands.waitSeconds(1), 
        arm.runOnce(() -> arm.goToPosition(0.125)),
        Commands.waitSeconds(1),
        arm.runOnce(() -> arm.goToPosition(0.25)));
   }

   public Command para(){

    return Commands.race(
        arm.runOnce(() -> arm.goToPosition(0.25)),
        Commands.print("Hello World"));
   }
}