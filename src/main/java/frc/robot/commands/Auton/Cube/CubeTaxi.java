package frc.robot.commands.Auton.Cube;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Arm.CubeScore;
import frc.robot.commands.Called.Drivetrain.Taxi;

public class CubeTaxi extends SequentialCommandGroup {
    
    public CubeTaxi() {

        addCommands(
            new SequentialCommandGroup(
                new CubeScore(),
                new Taxi()
            )
        );
    }
}
