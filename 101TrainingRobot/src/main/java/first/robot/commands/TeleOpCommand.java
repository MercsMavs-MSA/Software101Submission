package first.robot.commands;

import org.wpilib.command2.Command;
import org.wpilib.command2.Commands;

import first.robot.subsystems.WheelSubsystem;

public class TeleOpCommand {
    public WheelSubsystem wheel;

    public TeleOpCommand(WheelSubsystem wheel){
        this.wheel = wheel;
    }

    public Command extremeSetpoints(){
        return Commands.sequence(Commands.runOnce(() ->  wheel.setVelocity(0), wheel), Commands.waitSeconds(1), Commands.runOnce(() -> wheel.setVelocity(1), wheel));
    }

    public Command printParalellRun(){
        return Commands.parallel(Commands.runOnce(() -> wheel.setVelocity(.5), wheel), Commands.runOnce(() -> System.out.println("This command is running")), null)
        .andThen(Commands.runOnce(() -> wheel.setVelocity(0), wheel));

    }
}
