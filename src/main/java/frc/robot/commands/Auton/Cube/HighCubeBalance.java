package frc.robot.commands.Auton.Cube;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Arm.HighCubeScore;
import frc.robot.commands.Called.Drivetrain.CalledBalance;
import frc.robot.commands.Called.Drivetrain.TimedDrive;

public class HighCubeBalance extends SequentialCommandGroup {

    public HighCubeBalance() {

        addCommands(

            new SequentialCommandGroup(
                new HighCubeScore(),
                new TimedDrive(1.5, -0.50, -0.50),
                new CalledBalance()
            )
        );
    }
}
