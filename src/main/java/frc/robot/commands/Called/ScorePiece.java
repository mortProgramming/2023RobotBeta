package frc.robot.commands.Called;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class ScorePiece extends SequentialCommandGroup {

    public ScorePiece() {

        addCommands(

            new SequentialCommandGroup(
                new ClawControl(1),
                new ArmPistonControl(0),
                new TimedArm(0.8, -1),
                new ParallelCommandGroup(
                    new TimedArm(1.2, -0.15),
                    new SequentialCommandGroup(
                        new ArmPistonControl(1),
                        new Wait(1),
                        new ClawControl(0),
                        new TimedArm(0.5, -0.2),
                        new ArmPistonControl(0)
                    )
                ),
                new TimedArm(1, 0.5)
            )
        );
    }
}
