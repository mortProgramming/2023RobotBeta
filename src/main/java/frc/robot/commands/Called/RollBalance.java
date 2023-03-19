package frc.robot.commands.Called;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class RollBalance extends CommandBase {
    private Drivetrain drivetrain;

    private double input;
    
    public RollBalance() {
        drivetrain = Drivetrain.getInstance();

        addRequirements(drivetrain);
    }

    public void execute() {
        input = -Drivetrain.getPitch();
        if(Drivetrain.getRoll() > 5) {
            drivetrain.setFullDrive(0.25, -0.25);
        }
        else if(Drivetrain.getRoll() < -5) {
            drivetrain.setFullDrive(-0.25, 0.25);
        }
        else {
            if(input < 10 && input > -10) {
                drivetrain.setFullDrive(0, 0);
            }
            else {
                drivetrain.setFullDrive(drivetrain.getAutoBalanceController().calculate(input), drivetrain.getAutoBalanceController().calculate(input));
            }
        }
    }

    @Override
    public boolean isFinished() {
        // return drivetrain.getAutoBalanceController().atSetpoint();
        return false;
    }

    public void end() {
        drivetrain.setFullDrive(0, 0);
    }
}
