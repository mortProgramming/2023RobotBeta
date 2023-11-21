package frc.robot.commands.Auton.Cube;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Arm.CubeScore;
import frc.robot.commands.Called.Drivetrain.CalledBalance;
import frc.robot.commands.Called.Drivetrain.RollBalance;
import frc.robot.commands.Called.Drivetrain.TimedDrive;

public class CubeTaxiBalance extends SequentialCommandGroup {

    public CubeTaxiBalance() {

        addCommands(

            new SequentialCommandGroup(
                new CubeScore(),
                new TimedDrive(1.5, -0.50, -0.50),
                new TimedDrive(1.5, -0.4, -0.4),
                new TimedDrive(1.5, 0.50, 0.50),
                // new CalledBalance()
                new RollBalance()
            )
        );
    }
}
