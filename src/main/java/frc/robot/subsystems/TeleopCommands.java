package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;



public class TeleopCommands {
    private ArmSubsystem arm;
    
    public TeleopCommands(ArmSubsystem arm){
        this.arm = arm;
    }

    public Command moveArmSetpoint(){
        return Commands.sequence(
            Commands.runOnce(()  -> arm.goToPosition(.1)), Commands.waitSeconds(1),
            Commands.runOnce(() -> arm.goToPosition(.5)),  Commands.waitSeconds(1),
            Commands.runOnce(() -> arm.goToPosition(1)), Commands.waitSeconds(1),
            Commands.runOnce(() -> arm.goToPosition(0))
            ); 
    }

    public Command raceArmSet(){
        return Commands.race(
            Commands.run(() -> arm.goToPosition(.5)),
            Commands.run(() -> System.out.println("Arm Pos: " + arm.getRotation())),
            Commands.waitSeconds(5)
        ).andThen(Commands.run(() -> arm.goToPosition(0)));
    }

}
