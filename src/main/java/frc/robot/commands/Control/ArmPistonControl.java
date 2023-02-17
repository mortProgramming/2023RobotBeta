package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmPiston;

public class ArmPistonControl extends CommandBase{
    ArmPiston armPiston;
    private boolean setting;

    public ArmPistonControl(boolean setting) {
        this.setting = setting;

        armPiston = ArmPiston.getInstance();

        addRequirements(armPiston);
    }

    public void execute() {
        armPiston.setArmPiston(setting);
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) {}
}
