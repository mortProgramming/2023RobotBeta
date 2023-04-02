package frc.robot.commands.Called.Arm;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class ConeScore extends SequentialCommandGroup {

    public ConeScore() {

        addCommands(

            new SequentialCommandGroup(   
                new ClawControl(1),
                new ArmPistonControl(0),
                new TimedArm(1, -0.3),
                new ParallelCommandGroup(
                    new TimedArm(0.75, -0.045),
                    new SequentialCommandGroup(
                        new ArmPistonControl(1),
                        new Wait(1),
                        new ClawControl(0),
                        new ArmPistonControl(0)
                    )
                ),
                new TimedArm(1, 0.15)
            )
        );
    }
}
