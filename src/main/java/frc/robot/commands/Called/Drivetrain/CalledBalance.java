package frc.robot.commands.Called.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class CalledBalance extends CommandBase {
    private Drivetrain drivetrain;

    private double input;
    
    public CalledBalance() {
        drivetrain = Drivetrain.getInstance();

        addRequirements(drivetrain);
    }

    public void execute() {
        input = -Drivetrain.getPitch();
        if(input < 10 && input > -10) {
            drivetrain.setFullDrive(0, 0);
        }
        else {
            drivetrain.setFullDrive(drivetrain.getAutoBalanceController().calculate(input), drivetrain.getAutoBalanceController().calculate(input));
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
