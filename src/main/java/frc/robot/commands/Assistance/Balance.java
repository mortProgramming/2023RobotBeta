package frc.robot.commands.Assistance;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.Control;
import frc.robot.util.Logic;

public class Balance extends CommandBase{
    private Drivetrain drivetrain;

    private double littlePitch = 0;

    public Balance() {
        drivetrain = Drivetrain.getInstance();   
        addRequirements(drivetrain);
    }

    public void execute() {
        if(Logic.lessGreater(-2.5, Drivetrain.getPitch(), 2.5)) {
            littlePitch++;
        }
        else {
            littlePitch = 0;
        }

        if(littlePitch > 25) {
            drivetrain.setPIDStop();
        }
        else if(Logic.lessGreater(-15, Drivetrain.getPitch(), 15)) {
            drivetrain.setBalanceDrivetrain();
        }
        else {
            drivetrain.setFullAllDrive(-0.05 * Logic.plusNeg(Drivetrain.getPitch()));
        }
    }
}
