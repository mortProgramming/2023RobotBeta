package frc.robot.commands.Teleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmPiston;

public class ArmPistonControl extends CommandBase{
    ArmPiston armPiston;

    public ArmPistonControl() {
        armPiston = ArmPiston.getInstance();

        addRequirements(armPiston);
    }

    public void execute() {
        armPiston.setArmPiston(true);
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean interrupted) {
        armPiston.setArmPiston(false);
    }
}
