package frc.robot.commands.Auton.TestAuton;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Called.Arm.ArmToDegree;
import frc.robot.commands.Called.Arm.TimedArm;
import frc.robot.commands.Called.Drivetrain.CalledBalance;
import frc.robot.commands.Called.Drivetrain.TimedDrive;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class Tester3 extends SequentialCommandGroup {

    public Tester3() {

        addCommands(

            new SequentialCommandGroup(

                new ArmToDegree(90)

            )
        );
    }
}
