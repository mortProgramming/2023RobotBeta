package frc.robot.commands.Defaults;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class ClawDefault extends CommandBase{
    Claw claw;

    public ClawDefault() {
        claw = Claw.getInstance();

        addRequirements(claw);
    }

    public void execute() {
        claw.setClaw(false);
    }

    public boolean isFinished() {
        return false;
    }
}
