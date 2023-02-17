package frc.robot.commands.Auton;
import frc.robot.commands.Called.Turn;
import frc.robot.commands.Called.TimedDrive;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class Square extends SequentialCommandGroup {
    private double angle;
    private double speed;
    private double time;

    private double driveTime = 1;
    private double driveSpeed = 0.15;
    
    public Square(){
        addCommands(new Turn(angle), new TimedDrive(speed, time));

        new SequentialCommandGroup(
            new TimedDrive(driveSpeed, driveTime),
            new Turn(-90),
            new TimedDrive(driveSpeed, driveTime),
            new Turn(-90),
            new TimedDrive(driveSpeed, driveTime),
            new Turn(-90),
            new TimedDrive(driveSpeed, driveTime),
            new Turn(-90)
        );
    }
}