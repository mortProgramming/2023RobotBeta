package frc.robot.commands.Called;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TimedDrive extends CommandBase{
    Drivetrain drivetrain;
    private double speed;
    private double inputTime;

    private Timer timer = new Timer();

    public TimedDrive(double speed, double inputTime) {
        this.speed = speed;
        this.inputTime = inputTime;
        drivetrain = Drivetrain.getInstance();

        addRequirements(drivetrain);
    }

    public void initialize() {
        timer.reset();
        timer.start();
    }

    public void execute() {
        drivetrain.setUnlimitedAllDrive(speed);
    }

    public boolean isFinished() {
        return timer.get() > inputTime;
    }

    public void end(boolean interupted){
        drivetrain.setStop();
    }
}
