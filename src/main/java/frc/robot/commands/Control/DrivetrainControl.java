package frc.robot.commands.Control;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.Control;
import frc.robot.util.Logic;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainControl extends CommandBase {
  Drivetrain drivetrain;

  public DrivetrainControl() {
    drivetrain = Drivetrain.getInstance(); 

    addRequirements(drivetrain);
  }

  public void execute() {
    // if(drivetrain.getDirection() == 1) {
    //   drivetrain.setDrive(Control.getLeftJoystickY(), Control.getRightJoystickY());
    // }
    // else {
    //   drivetrain.setDrive(-Control.getRightJoystickY(), -Control.getLeftJoystickY());
    // }

    // if(drivetrain.getDirection() == 1) {
    //   drivetrain.setFullDrive(Logic.modifySquareAxis(Control.getLeftJoystickY(), Control.getLeftThrottle()),
    //     Logic.modifySquareAxis(Control.getRightJoystickY(), Control.getLeftThrottle()));
    // }
    // else {
    //   drivetrain.setFullDrive(Logic.modifySquareAxis(-Control.getRightJoystickY(), Control.getLeftThrottle()),
    //     Logic.modifySquareAxis(-Control.getLeftJoystickY(), Control.getLeftThrottle()));
    // }

    // drivetrain.setDrive(Control.getLeftJoystickY(), Control.getRightJoystickY());

    drivetrain.setFullDrive(Logic.modifySquareAxis(-Control.getLeftJoystickY(), Control.getLeftThrottle()),
    Logic.modifySquareAxis(-Control.getRightJoystickY(), Control.getLeftThrottle()));
  }

  public boolean isFinished() {
    return false;
  }
}
