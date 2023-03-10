package frc.robot.commands.Called;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class Taxi extends SequentialCommandGroup {

    public Taxi() {

        addCommands(

            new SequentialCommandGroup(
                new TimedDrive(4, -0.25, -0.25)
            )
        );
    }
}
