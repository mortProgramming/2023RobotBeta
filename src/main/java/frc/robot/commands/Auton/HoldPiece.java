package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.TimedArm;
import frc.robot.commands.Called.TimedDrive;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class HoldPiece extends SequentialCommandGroup {

    public HoldPiece() {

        addCommands(

            new SequentialCommandGroup(
                // new ClawControl(0, true),
                // new ArmPistonControl(0, true),
                // new Wait(2),
                // new TimedDrive(0.15, 0.25),
                new TimedArm(10, -1)
                // new ArmPistonControl(1, true),
                // new Wait(2),
                // new ClawControl(1, true),
                // new ArmPistonControl(0, true)
            )
        );
    }
}
