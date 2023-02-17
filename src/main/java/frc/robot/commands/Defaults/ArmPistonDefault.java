package frc.robot.commands.Defaults;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmPiston;

public class ArmPistonDefault extends CommandBase{
    ArmPiston armPiston;

    public ArmPistonDefault() {
        armPiston = ArmPiston.getInstance();

        addRequirements(armPiston);
    }

    public void initialize() {
        armPiston.setArmPiston(false);
    }

    public boolean isFinished() {
        return false;
    }
}
