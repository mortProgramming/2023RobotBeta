package frc.robot.commands.Control;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.Control;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainControl extends CommandBase{
  /** Creates a new Easy. */
  Drivetrain drivetrain;

  private static double leftSpeed;
  private static double rightSpeed;

  public DrivetrainControl(double leftSpeed, double rightSpeed) {

    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;

    drivetrain = Drivetrain.getInstance(); 

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      drivetrain.setDrive(leftSpeed, rightSpeed);
      // drivetrain.setLeftDrive(Control.getLeftJoystickY());
      // drivetrain.setRightDrive(Control.getRightJoystickY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
