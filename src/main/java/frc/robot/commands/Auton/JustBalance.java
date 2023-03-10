package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.Balance;
import frc.robot.commands.Called.ScorePiece;
import frc.robot.commands.Called.Taxi;
import frc.robot.commands.Called.TimedArm;
import frc.robot.commands.Called.TimedDrive;
import frc.robot.commands.Called.Wait;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;

public class JustBalance extends SequentialCommandGroup {

    public JustBalance() {

        addCommands(

            new SequentialCommandGroup(

                new TimedDrive(1.5, -0.5, -0.5),
                new Balance()
                
            )
        );
    }
}
