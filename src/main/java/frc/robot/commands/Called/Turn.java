package frc.robot.commands.Called;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Turn extends CommandBase{
    Drivetrain drivetrain;
    private double angle;
    private double oldAngle;

    public Turn(double angle) {
        this.angle = angle;
        drivetrain = Drivetrain.getInstance();

        addRequirements(drivetrain);
    }

    public void initialize() {
        oldAngle = Drivetrain.getYaw();
    }

    public void execute() {
        drivetrain.setFullDrive(
            drivetrain.getTurnController().calculate(Drivetrain.getYaw(), oldAngle + angle),
            drivetrain.getTurnController().calculate(Drivetrain.getYaw(), oldAngle + angle)
        );
    }

    @Override
    public boolean isFinished() {
        if(drivetrain.getTurnController().atSetpoint()){
            System.out.println("finished");
            return true;
        }
        else{
            return false;
        }
    }

    public void end(boolean interupted){
        drivetrain.setFullDrive(0, 0);
    }
}
