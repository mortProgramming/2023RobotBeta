package frc.robot.commands.Auton;
import frc.robot.commands.Called.Turn;
import frc.robot.commands.Called.TimedDrive;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Square extends SequentialCommandGroup {
    private double driveTime = 1;
    private double driveSpeed = 0.15;
    
    public Square() {
        addCommands(
            new SequentialCommandGroup(
                new TimedDrive(driveTime, driveSpeed, driveSpeed),
                new Turn(-90),
                new TimedDrive(driveTime, driveSpeed, driveSpeed),
                new Turn(-90),
                new TimedDrive(driveTime, driveSpeed, driveSpeed),
                new Turn(-90),
                new TimedDrive(driveTime, driveSpeed, driveSpeed),
                new Turn(-90)
            )
        );
    }
}