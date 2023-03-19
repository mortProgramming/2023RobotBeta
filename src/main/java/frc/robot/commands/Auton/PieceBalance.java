package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.CalledBalance;
import frc.robot.commands.Called.TimedArm;
import frc.robot.commands.Called.TimedDrive;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class PieceBalance extends SequentialCommandGroup {

    public PieceBalance() {

        addCommands(

            new SequentialCommandGroup(
                new ClawControl(1),
                new ArmPistonControl(0),
                new TimedArm(0.95, -0.3),
                new ParallelCommandGroup(
                    new TimedArm(0.75, -0.045),
                    new SequentialCommandGroup(
                        new ArmPistonControl(1),
                        new Wait(1),
                        new ClawControl(0),
                        new ArmPistonControl(0)
                    )
                ),
                new TimedArm(1, 0.09),
                new TimedDrive(1.5, -0.5, -0.5),
                new CalledBalance()
            )
        );
    }
}
