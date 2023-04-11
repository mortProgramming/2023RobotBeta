package frc.robot.commands.Control;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmMotor;
import frc.robot.subsystems.ArmPiston;
import frc.robot.util.Control;
import frc.robot.util.Logic;
import static frc.robot.util.Constants.*;

public class ArmMotorControl extends CommandBase {
    ArmMotor armMotor;
    ArmPiston armPiston;

    private double direction;

    private boolean newButton1 = false;
    private boolean oldButton1 = true; //Left joystick button
    private boolean pressedButton1 = false;
    private boolean alternateButton1 = false;

    public ArmMotorControl() {
        // public ArmMotorControl(double direction) {
        // this.direction = direction;

        armMotor = ArmMotor.getInstance();
        armPiston = ArmPiston.getInstance();

        addRequirements(armMotor);
    }

    public void execute() {
        oldButton1 = newButton1;
        newButton1 = Control.getLeftControllerJoystickButton();
        pressedButton1 = Logic.pressedLogic(newButton1, oldButton1);
        alternateButton1 = Logic.pressed2ToggleLogic(pressedButton1, alternateButton1);

        if(alternateButton1) {
            direction = 1;
        }
        else {
            direction = -1;
        }

        if(armPiston.getArmPiston() == DoubleSolenoid.Value.kForward) {
            armMotor.setArmMotor(direction * Control.getLeftControllerJoystickY() + 
            ARM_IN_SIN_CONSTANT * Logic.armStabalize(armMotor.getArmMotorVal()));
        }
        else {
            armMotor.setArmMotor(direction * Control.getLeftControllerJoystickY() + 
            ARM_OUT_SIN_CONSTANT * Logic.armStabalize(armMotor.getArmMotorVal()));
        }

        // if(armPiston.getArmPiston() == DoubleSolenoid.Value.kForward) {
        //     armMotor.setArmMotor((direction * Control.getLeftControllerJoystickY() * 
        //     (1 - ARM_IN_SIN_CONSTANT * Logic.armStabalize(armMotor.getArmMotorVal()))) + 
        //     ARM_IN_SIN_CONSTANT * Logic.armStabalize(armMotor.getArmMotorVal()));
        // }
        // else {
        //     armMotor.setArmMotor((direction * Control.getLeftControllerJoystickY() * 
        //     (1 - ARM_OUT_SIN_CONSTANT * Logic.armStabalize(armMotor.getArmMotorVal()))) + 
        //     ARM_OUT_SIN_CONSTANT * Logic.armStabalize(armMotor.getArmMotorVal()));
        // }

        // if(armPiston.getArmPiston() == DoubleSolenoid.Value.kReverse) {
        //     armMotor.setArmMotor(Logic.scale(
        //         (direction * Control.getLeftControllerJoystickY()), 
        //         (ARM_OUT_SIN_CONSTANT * Logic.armStabalize(armMotor.getArmMotorVal()))
        //     ));
        // }
        // else {
        //     armMotor.setArmMotor(Logic.scale(
        //         (direction * Control.getLeftControllerJoystickY()), 
        //         (ARM_IN_SIN_CONSTANT * Logic.armStabalize(armMotor.getArmMotorVal()))
        //     ));
        // }

        //  armMotor.setArmMotor(direction * Control.getLeftControllerJoystickY());
        // armMotor.setArmMotor(armMotor.getArmFeedForward().calculate(Control.getLeftControllerJoystickY()));

        // System.out.println(armMotor.getArmMotorVal());
    }

    public boolean isFinished() {
        return false;
    }
}
