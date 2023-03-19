package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Score;
import frc.robot.commands.Called.Taxi;

public class ScoreTaxi extends SequentialCommandGroup {
    
    public ScoreTaxi() {

        addCommands(
            new SequentialCommandGroup(
                new Score(),
                new Taxi()
            )
        );
    }
}
