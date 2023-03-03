package frc.robot.commands.Control;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmMotor;
import frc.robot.util.Control;

public class ArmMotorControl extends CommandBase{
    ArmMotor armMotor;

    private static double speed;

    public ArmMotorControl(double speed) {

        this.speed = speed;

        armMotor = ArmMotor.getInstance();

        addRequirements(armMotor);
    }

    public void execute() {
        armMotor.setArmMotor(speed);
    }

    public boolean isFinished() {
        return false;
    }
}
