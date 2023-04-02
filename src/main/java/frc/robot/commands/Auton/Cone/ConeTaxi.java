package frc.robot.commands.Auton.Cone;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Arm.ConeScore;
import frc.robot.commands.Called.Drivetrain.Taxi;

public class ConeTaxi extends SequentialCommandGroup {
    
    public ConeTaxi() {

        addCommands(
            new SequentialCommandGroup(
                new ConeScore(),
                new Taxi()
            )
        );
    }
}
