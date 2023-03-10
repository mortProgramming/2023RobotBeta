package frc.robot.commands.Control;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmMotor;
import frc.robot.subsystems.ArmPiston;
import frc.robot.util.Control;
import frc.robot.util.Logic;
import frc.robot.util.Constants;

public class ArmMotorControl extends CommandBase {
    ArmMotor armMotor;
    // ArmPiston armPiston;

    public ArmMotorControl() {
        armMotor = ArmMotor.getInstance();
        // armPiston = ArmPiston.getInstance();

        addRequirements(armMotor);
    }

    public void execute() {
        armMotor.setArmMotor(Control.getLeftControllerJoystickY());

        // if(armMotor.getDirection() == 1) {
        //     armMotor.setArmMotor(Control.getLeftControllerJoystickY());
        // }
        // else if(armMotor.getDirection() == -1) {
        //     armMotor.setArmMotor(-Control.getLeftControllerJoystickY());
        // }

        // if(armMotor.getDirection() == 1) {
        //     if(armPiston.getArmPiston() == DoubleSolenoid.Value.kForward) {
        //         armMotor.setArmMotor(Control.getLeftControllerJoystickY() + 
        //         Constants.ARM_IN_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()));
        //     }
        //     else {
        //         armMotor.setArmMotor(Control.getLeftControllerJoystickY() + 
        //         Constants.ARM_OUT_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()));
        //     }
        // }
        // else {
        //     if(armPiston.getArmPiston() == DoubleSolenoid.Value.kForward) {
        //         armMotor.setArmMotor(-Control.getLeftControllerJoystickY() + 
        //         Constants.ARM_IN_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()));
        //     }
        //     else {
        //         armMotor.setArmMotor(-Control.getLeftControllerJoystickY() + 
        //         Constants.ARM_OUT_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()));
        //     }
        // }

        // if(armMotor.getDirection() == 1) {
        //     if(armPiston.getArmPiston() == DoubleSolenoid.Value.kForward) {
        //         armMotor.setArmMotor((Control.getLeftControllerJoystickY() * 
        //         (1 - Constants.ARM_IN_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()))) + 
        //         Constants.ARM_IN_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()));
        //     }
        //     else {
        //         armMotor.setArmMotor((Control.getLeftControllerJoystickY() * 
        //         (1 - Constants.ARM_OUT_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()))) + 
        //         Constants.ARM_OUT_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()));
        //     }
        // }
        // else {
        //     if(armPiston.getArmPiston() == DoubleSolenoid.Value.kForward) {
        //         armMotor.setArmMotor((-Control.getLeftControllerJoystickY() * 
        //         (1 - Constants.ARM_IN_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()))) + 
        //         Constants.ARM_IN_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()));
        //     }
        //     else {
        //         armMotor.setArmMotor((Control.getLeftControllerJoystickY() * 
        //         (1 - Constants.ARM_OUT_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()))) + 
        //         Constants.ARM_OUT_SIN_CONSTANT * Logic.ArmStabalize(armMotor.getArmMotor().getEncoder().getPosition()));
        //     }
        // }
    }

    public boolean isFinished() {
        return false;
    }
}
