package frc.robot.commands.TestAuton;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Turn;
// import frc.robot.commands.Called.TimedArm;
import frc.robot.commands.Called.TimedDrive;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class Tester2 extends SequentialCommandGroup {

    public Tester2() {

        addCommands(

            new SequentialCommandGroup(

                new Turn(90)

            )
        );
    }
}
