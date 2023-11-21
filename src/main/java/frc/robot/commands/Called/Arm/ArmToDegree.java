package frc.robot.commands.Called.Arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmMotor;
import frc.robot.util.Logic;
import static frc.robot.util.Constants.*;

public class ArmToDegree extends CommandBase {
    ArmMotor armMotor;

    private double wantedPosition;
    private double wantedDegrees;

    public ArmToDegree(double wantedDegrees) {
        this.wantedDegrees = wantedDegrees;

        armMotor = ArmMotor.getInstance();

        addRequirements(armMotor);
    }

    public void initialize() {
        wantedPosition = wantedDegrees;
    }

    public void execute() {
        armMotor.setAutoArmMotor(-armMotor.getArmDegreeController().calculate(Logic.armMotorPositionToDegrees(armMotor.getArmMotorVal()), wantedPosition));
    }

    public boolean isFinished() {
        return armMotor.getArmDegreeController().atSetpoint();
        // return false;
    }

    public void end() {
        armMotor.setAutoArmMotor(0);
    }
}
