package frc.robot.commands.Control;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.Control;
import edu.wpi.first.wpilibj2.command.CommandBase;
public class DrivetrainControl extends CommandBase{
  /** Creates a new Easy. */
  Drivetrain drivetrain;

  public DrivetrainControl() {
    // Use addRequirements() here to declare subsystem dependencies.
    drivetrain = Drivetrain.getInstance();   
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      drivetrain.setFullLeftDrive(Control.getLeftJoystickY());
      drivetrain.setFullRightDrive(Control.getRightJoystickY());
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
