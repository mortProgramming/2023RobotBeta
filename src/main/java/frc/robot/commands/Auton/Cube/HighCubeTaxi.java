package frc.robot.commands.Auton.Cube;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Arm.HighCubeScore;
import frc.robot.commands.Called.Drivetrain.Taxi;

public class HighCubeTaxi extends SequentialCommandGroup {
    
    public HighCubeTaxi() {

        addCommands(
            new SequentialCommandGroup(
                new HighCubeScore(),
                new Taxi()
            )
        );
    }
}
