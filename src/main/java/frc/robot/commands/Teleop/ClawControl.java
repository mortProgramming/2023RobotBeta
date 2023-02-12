package frc.robot.commands.Teleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class ClawControl extends CommandBase{
    Claw claw;

    public ClawControl() {
        claw = Claw.getInstance();

        addRequirements(claw);
    }

    public void execute() {
        claw.setClaw(true);
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) {
        claw.setClaw(false);
    }
}
