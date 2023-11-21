package frc.robot.commands.Auton.Cone;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Arm.ConeScore;
import frc.robot.commands.Called.Drivetrain.CalledBalance;
import frc.robot.commands.Called.Drivetrain.RollBalance;
import frc.robot.commands.Called.Drivetrain.TimedDrive;

public class ConeTaxiBalance extends SequentialCommandGroup {

    public ConeTaxiBalance() {

        addCommands(

            new SequentialCommandGroup(
                new ConeScore(),
                new TimedDrive(1.5, -0.50, -0.50),
                new TimedDrive(1.5, -0.4, -0.4),
                new TimedDrive(1.5, 0.50, 0.50),
                // new CalledBalance()
                new RollBalance()
            )
        );
    }
}
