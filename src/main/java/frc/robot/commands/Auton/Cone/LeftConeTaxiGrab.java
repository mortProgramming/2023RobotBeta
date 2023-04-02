package frc.robot.commands.Auton.Cone;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.GroundPiece;
import frc.robot.commands.Called.Arm.BumperArm;
import frc.robot.commands.Called.Arm.ConeScore;
import frc.robot.commands.Called.Drivetrain.Taxi;
import frc.robot.commands.Called.Drivetrain.Turn;

public class LeftConeTaxiGrab extends SequentialCommandGroup {
    
    public LeftConeTaxiGrab() {

        addCommands(
            new SequentialCommandGroup(
                new ConeScore(),
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
