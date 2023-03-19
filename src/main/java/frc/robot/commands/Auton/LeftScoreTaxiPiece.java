package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.BumperArm;
import frc.robot.commands.Called.GroundPiece;
import frc.robot.commands.Called.Score;
import frc.robot.commands.Called.Taxi;
import frc.robot.commands.Called.Turn;

public class LeftScoreTaxiPiece extends SequentialCommandGroup {
    
    public LeftScoreTaxiPiece() {

        addCommands(
            new SequentialCommandGroup(
                new Score(),
                new ParallelCommandGroup(
                    new Taxi(),
                    new BumperArm()
                ),
                new Turn(180),
                new GroundPiece()
            )
        );
    }
}
