package frc.robot.commands.Auton.TestAuton;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.CalledBalance;
import frc.robot.commands.Called.GroundPiece;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Called.Arm.BumperArm;
import frc.robot.commands.Called.Arm.ConeScore;
import frc.robot.commands.Called.Arm.TimedArm;
import frc.robot.commands.Called.Drivetrain.Taxi;
import frc.robot.commands.Called.Drivetrain.TimedDrive;
import frc.robot.commands.Called.Drivetrain.Turn;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class Tester1 extends SequentialCommandGroup {

    public Tester1() {

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
