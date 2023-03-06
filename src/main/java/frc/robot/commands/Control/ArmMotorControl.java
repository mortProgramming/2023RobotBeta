package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmMotor;
import frc.robot.util.Control;

public class ArmMotorControl extends CommandBase{
    ArmMotor armMotor;

    public ArmMotorControl() {
        armMotor = ArmMotor.getInstance();

        addRequirements(armMotor);
    }

    public void execute() {
        if(armMotor.getDirection() == 1) {
            armMotor.setArmMotor(Control.getLeftControllerJoystickY());
        }
        else {
            armMotor.setArmMotor(-Control.getLeftControllerJoystickY());
        }
    }

    public boolean isFinished() {
        return false;
    }
}
