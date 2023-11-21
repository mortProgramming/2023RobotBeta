package frc.robot.commands.Auton.Cone;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.GroundPiece;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Called.Arm.BumperArm;
import frc.robot.commands.Called.Arm.ConeScore;
import frc.robot.commands.Called.Drivetrain.Taxi;
import frc.robot.commands.Called.Drivetrain.TimedDrive;
import frc.robot.commands.Called.Drivetrain.Turn;

public class LeftConeTaxiGrab extends SequentialCommandGroup {
    
    public LeftConeTaxiGrab() {

        addCommands(
            new SequentialCommandGroup(
                new ConeScore(),
                new ParallelCommandGroup(
                    new TimedDrive(1.5, -0.5, -0.5),
                    new SequentialCommandGroup(
                        new Wait(3),
                        new BumperArm()
                    )
                ),
                new TimedDrive(1, 0.5, -0.5),
                new GroundPiece()
            )
        );
    }
}
