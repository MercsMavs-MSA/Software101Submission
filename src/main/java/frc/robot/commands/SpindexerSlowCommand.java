package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.SpindexerConstants;
import frc.robot.subsystems.SpindexerSubsystem;

public class SpindexerSlowCommand extends Command {
    private final SpindexerSubsystem m_spindexer;

    public SpindexerSlowCommand(SpindexerSubsystem subsystem) {
        m_spindexer = subsystem;
        addRequirements(m_spindexer);
    }

    @Override
    public void initialize() {
        m_spindexer.spinAtVelocity(SpindexerConstants.SLOW_VELOCITY);
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted) {
        m_spindexer.spinAtVelocity(SpindexerConstants.STOP_VELOCITY);
    }

    @Override
    public boolean isFinished() {
        return false; // Run continuously while the command/button is active
    }
}
