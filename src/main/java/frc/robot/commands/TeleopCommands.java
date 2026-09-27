package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Kicker;

public class TeleopCommands extends Command {
    private Kicker kicker; 

    public TeleopCommands(Kicker kicker){
        this.kicker = kicker; 
        addRequirements(kicker); 
    }

    public Command sequential(){

        return Commands.sequence( 
        kicker.runOnce(() -> kicker.goToVelocity(0)),
        Commands.waitSeconds(1), 
        kicker.runOnce(() -> kicker.goToVelocity(10)), 
        Commands.waitSeconds(1), 
        kicker.runOnce(() -> kicker.goToVelocity(20)));
    }

    public Command parallel(){
    
        return Commands.race(
            kicker.run(() -> kicker.goToVelocity(20)), 
            Commands.run(() -> Commands.print("Hello World")), 
            Commands.waitSeconds(5)); 
    
    }
}
