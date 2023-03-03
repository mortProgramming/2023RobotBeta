package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmPiston;

public class ArmPistonControl extends CommandBase{
    ArmPiston armPiston;
    private int setting;

    public ArmPistonControl(int setting) {
        this.setting = setting;

        armPiston = ArmPiston.getInstance();

        addRequirements(armPiston);
    }

    @Override
    public void initialize() {
        armPiston.setMultiArmPiston(setting);
    }

    public boolean isFinished() {
        return true;
    }

    public void end(boolean interrupted) {}
}
