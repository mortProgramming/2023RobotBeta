package frc.robot.commands.Called;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TimedDrive extends CommandBase{
    Drivetrain drivetrain;

    private double time;
    private double leftSpeed;
    private double rightSpeed;

    private Timer timer = new Timer();

    public TimedDrive(double time, double leftSpeed, double rightSpeed) {
        this.time = time;
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;

        drivetrain = Drivetrain.getInstance();

        addRequirements(drivetrain);
    }

    public void initialize() {
        timer.reset();
        timer.start();
    }

    public void execute() {
        drivetrain.setFullDrive(leftSpeed, rightSpeed);
    }

    public boolean isFinished() {
        return timer.get() > time;
    }

    public void end(boolean interupted){
        drivetrain.setStop();
    }
}
