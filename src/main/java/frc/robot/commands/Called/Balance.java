package frc.robot.commands.Called;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Balance extends CommandBase {
    private Drivetrain drivetrain;

    private double input;
    
    public Balance() {
        drivetrain = Drivetrain.getInstance();

        addRequirements(drivetrain);
    }

    public void execute() {
        input = -Drivetrain.getPitch();
        if(input < 10 && input > -10) {
            drivetrain.setFullDrive(0, 0);
        }
        else {
            drivetrain.setFullDrive(drivetrain.getBalanceController().calculate(input), drivetrain.getBalanceController().calculate(input));
        }
        System.out.println(input);
    }

    @Override
    public boolean isFinished() {
        return drivetrain.getBalanceController().atSetpoint();
    }

    public void end() {
        drivetrain.setFullDrive(0, 0);
    }
}
