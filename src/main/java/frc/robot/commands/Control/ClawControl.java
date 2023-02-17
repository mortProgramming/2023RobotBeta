package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class ClawControl extends CommandBase{
    Claw claw;
    private boolean setting;

    public ClawControl(boolean setting) {
        this.setting = setting;        

        claw = Claw.getInstance();

        addRequirements(claw);
    }

    public void execute() {
        claw.setClaw(setting);
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) { }
}
