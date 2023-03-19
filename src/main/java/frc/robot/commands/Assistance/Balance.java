package frc.robot.commands.Assistance;

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
        // if(input < 10 && input > -10) {
        //     drivetrain.setFullDrive(0, 0);
        // }
        // else {
            drivetrain.setFullDrive(drivetrain.getAssistBalanceController().calculate(input), drivetrain.getAutoBalanceController().calculate(input));
        // }
    }

    @Override
    public boolean isFinished() {
        return drivetrain.getAssistBalanceController().atSetpoint();
    }

    public void end() {
        new Stop();
    }
}
