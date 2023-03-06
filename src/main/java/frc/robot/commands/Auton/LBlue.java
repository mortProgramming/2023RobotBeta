package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Balance;
import frc.robot.commands.Called.ScorePiece;
import frc.robot.commands.Called.TimedArm;
import frc.robot.commands.Called.TimedDrive;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class LBlue extends SequentialCommandGroup {

    public LBlue() {

        addCommands(

            new SequentialCommandGroup(
                new ScorePiece(),
                new TimedDrive(5, -0.25, -0.25)
            )
        );
    }
}
