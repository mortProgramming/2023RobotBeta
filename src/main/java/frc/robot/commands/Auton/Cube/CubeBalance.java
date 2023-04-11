package frc.robot.commands.Auton.Cube;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.CalledBalance;
import frc.robot.commands.Called.Arm.CubeScore;
import frc.robot.commands.Called.Drivetrain.TimedDrive;

public class CubeBalance extends SequentialCommandGroup {

    public CubeBalance() {

        addCommands(

            new SequentialCommandGroup(
                new CubeScore(),
                new TimedDrive(1.5, -0.50, -0.50),
                new CalledBalance()
            )
        );
    }
}
