package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Assistance.Balance;
import frc.robot.commands.Called.Score;
import frc.robot.commands.Called.TimedDrive;

public class ScoreBalance extends SequentialCommandGroup {

    public ScoreBalance() {

        addCommands(

            new SequentialCommandGroup(
                new Score(),
                new TimedDrive(1.5, 0.50, 0.50),
                new Balance()
            )
        );
    }
}
