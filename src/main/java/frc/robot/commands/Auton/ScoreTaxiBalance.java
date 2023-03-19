package frc.robot.commands.Auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Called.CalledBalance;
import frc.robot.commands.Called.RollBalance;
import frc.robot.commands.Called.Score;
import frc.robot.commands.Called.TimedDrive;

public class ScoreTaxiBalance extends SequentialCommandGroup {

    public ScoreTaxiBalance() {

        addCommands(

            new SequentialCommandGroup(
                new Score(),
                new TimedDrive(1.5, -0.50, -0.50),
                new TimedDrive(1.5, -0.4, -0.4),
                new TimedDrive(1.5, 0.50, 0.50),
                // new CalledBalance()
                new RollBalance()
            )
        );
    }
}
