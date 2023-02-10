package frc.robot.commands.Teleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Stop extends CommandBase{
    Drivetrain drivetrain;

    public Stop(){
        drivetrain = Drivetrain.getInstance();   
        addRequirements(drivetrain);
    }

    public void execute(){
        drivetrain.setPIDStop();
    }
}
