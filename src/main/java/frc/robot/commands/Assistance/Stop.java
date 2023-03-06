package frc.robot.commands.Assistance;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Stop extends CommandBase {
    Drivetrain drivetrain;

    public Stop() {
        drivetrain = Drivetrain.getInstance();   

        addRequirements(drivetrain);
    }

    public void execute() {
        drivetrain.setFullDrive(
            drivetrain.getStopController().calculate(drivetrain.getLeftDrive().getEncoder().getVelocity()),
            drivetrain.getStopController().calculate(drivetrain.getRightDrive().getEncoder().getVelocity())
        );
    }

    public boolean isFinished() {
        return false;
    }
}
