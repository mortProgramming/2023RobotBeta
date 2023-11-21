package frc.robot.commands.Called.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class PositionDrive extends CommandBase {
    Drivetrain drivetrain;

    private double maxSpeed;
    private double leftDistance;
    private double rightDistance;

    private double originalPositionLeft;
    private double originalPositionRight;

    public PositionDrive(double maxSpeed, double leftDistance, double rightDistance) {
        this.maxSpeed = maxSpeed;
        this.leftDistance = leftDistance;
        this.rightDistance = rightDistance;

        drivetrain = Drivetrain.getInstance();

        addRequirements(drivetrain);
    }

    public void initialize() {
        originalPositionLeft = drivetrain.getLeftDrive().getEncoder().getPosition();
        originalPositionRight = drivetrain.getRightDrive().getEncoder().getPosition();
    }

    public void execute() {
        if(drivetrain.getLeftDrive().getEncoder().getPosition() < originalPositionLeft) {
            drivetrain.setLeftDrive(maxSpeed);
        }
        if(drivetrain.getRightDrive().getEncoder().getPosition() < originalPositionLeft) {
            drivetrain.setLeftDrive(maxSpeed);
        }
    }

    public boolean isFinished() {
        return true;
    }

    public void end(boolean interupted){
        drivetrain.setFullDrive(0, 0);
    }
}
