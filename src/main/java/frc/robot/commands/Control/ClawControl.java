package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class ClawControl extends CommandBase{
    Claw claw;
    private int setting;

    public ClawControl(int setting) {
        this.setting = setting;   

        claw = Claw.getInstance();

        addRequirements(claw);
    }

    public void initialize() {
        claw.setMultiClaw(setting);
    }

    public boolean isFinished() {
        return true;
    }

    public void end(boolean interrupted) { }
}
