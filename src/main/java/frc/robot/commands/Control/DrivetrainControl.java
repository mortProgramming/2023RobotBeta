package frc.robot.commands.Control;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.Control;
import frc.robot.util.Logic;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.util.Constants.*;

public class DrivetrainControl extends CommandBase {
  Drivetrain drivetrain;

  private double direction;
  private double sensitivity;

  private boolean newButton1 = false;
  private boolean oldButton1 = true; //Right trigger
  private boolean pressedButton1 = false;
  private boolean alternateButton1 = true;

  private boolean newButton2 = false; //Button 4
  private boolean oldButton2 = true;
  private boolean pressedButton2 = false;
  private boolean alternateButton2 = true;

  public DrivetrainControl() {
  // public DrivetrainControl(double direction) {
    // this.direction = direction;

    drivetrain = Drivetrain.getInstance(); 

    addRequirements(drivetrain);
  }

  public void execute() {
    oldButton1 = newButton1;
    newButton1 = Control.getRightTrigger();
    pressedButton1 = Logic.pressedLogic(newButton1, oldButton1);
    alternateButton1 = Logic.pressed2ToggleLogic(pressedButton1, alternateButton1);

    oldButton2 = newButton2;
    newButton2 = Control.getButton4();
    pressedButton2 = Logic.pressedLogic(newButton2, oldButton2);
    alternateButton2 = Logic.pressed2ToggleLogic(pressedButton2, alternateButton2);

    if(alternateButton1) {
      direction = 1;
    }
    else {
      direction = -1;
    }

    if(alternateButton2) {
      sensitivity = 1;
    }
    else {
      sensitivity = LOW_SENSITIVITY;
    }

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

    // drivetrain.setFullDrive(Logic.modifySquareAxis(-Control.getLeftJoystickY(), Control.getLeftThrottle()),
    // Logic.modifySquareAxis(-Control.getRightJoystickY(), Control.getLeftThrottle()));

  //   drivetrain.setFullDrive(
  //     direction * Logic.modifySquareAxis(-Control.getLeftJoystickY(), Control.getLeftThrottle()),
  //     direction * Logic.modifySquareAxis(-Control.getRightJoystickY(), Control.getLeftThrottle()));
  // }

  //this one
  //  if(direction > 0) {
  //   drivetrain.setFullDrive(
  //     sensitivity * Logic.modifyAxis(-Control.getLeftJoystickY(), 1),
  //     sensitivity * Logic.modifyAxis(-Control.getRightJoystickY(), 1));
  //   }
  //   else {
  //     drivetrain.setFullDrive(
  //     -sensitivity * Logic.modifyAxis(-Control.getRightJoystickY(), 1),
  //     -sensitivity * Logic.modifyAxis(-Control.getLeftJoystickY(), 1));
  //   }

    if(direction > 0) {
    drivetrain.setFullDrive(
      sensitivity * Logic.modifyAxis(-Control.getLeftJoystickY(), Control.getLeftThrottle()),
      sensitivity * Logic.modifyAxis(-Control.getRightJoystickY(), Control.getLeftThrottle()));
    }
    else {
      drivetrain.setFullDrive(
      -sensitivity * Logic.modifyAxis(-Control.getRightJoystickY(), Control.getLeftThrottle()),
      -sensitivity * Logic.modifyAxis(-Control.getLeftJoystickY(), Control.getLeftThrottle()));
    }

    // drivetrain.setArcadeDrive(
    //   direction * sensitivity * Control.getRightJoystickY(),
    //   direction * sensitivity * Control.getRightControllerJoystickZ());

    // System.out.println(direction);
  }

  public boolean isFinished() {
    return false;
    // return drivetrain.getCommandOff();
  }
}
