package frc.robot.commands.Teleop;
import frc.robot.Operator;
import frc.robot.subsystems.Drivetrain;
import frc.robot.Logic;
import edu.wpi.first.wpilibj2.command.CommandBase;
public class DrivetrainCommand extends CommandBase{
  /** Creates a new Easy. */
  Drivetrain drivetrain;

  private boolean oldButton1 = true;  //Right trigger
  private boolean newButton1 = false;
  private boolean pressedButton1 = false;
  private boolean alternateButton1 = false;

  private boolean oldButton2 = true;  //Left trigger
  private boolean newButton2 = false;
  private boolean pressedButton2 = false;
  private boolean alternateButton2 = false;

  private double autoDriveTrainSpeed = 0.2;
  private double autoDriveTrainSlowSpeed = 0.1;

  public DrivetrainCommand() {
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
    oldButton1 = newButton1;
    newButton1 = Operator.getRightTrigger();
    pressedButton1 = Operator.getRightJoystick().getTriggerPressed();
    alternateButton1 = Logic.pressed2ToggleLogic(pressedButton1, alternateButton1);

    oldButton2 = newButton2;
    newButton2 = Operator.getLeftTrigger();
    pressedButton2 = Operator.getLeftJoystick().getTriggerPressed();
    alternateButton2 = Logic.pressed2ToggleLogic(pressedButton2, alternateButton2);

    System.out.println(Operator.getPitch());

    Operator.SmartDashboard1(Operator.getLeftThrottle(), "Sensitivity");
    Operator.SmartDashboard2(Operator.getPitch(), "Pitch");
    Operator.SmartDashboard3(Operator.getRoll(), "Roll");
    Operator.SmartDashboard4(Operator.getYaw(), "Yaw");
    Operator.SmartDashboard5(Operator.getXVelocity(), "X Velocity");
    Operator.SmartDashboard6(Operator.getYVelocity(), "Y Velocity");
    Operator.SmartDashboard7(Operator.getZVelocity(), "Z Velocity");

    if(alternateButton1){
      if(Operator.getPitch() < 3 && Operator.getPitch() > -3){
        drivetrain.setUnlimitedAllDrive(autoDriveTrainSlowSpeed * Logic.plusNeg(Operator.getPitch()));
      }
      else if(Logic.lessGreater(3, Operator.getPitch(), 5) || Logic.lessGreater(-5, Operator.getPitch(), -3)){
        drivetrain.setUnlimitedAllDrive(autoDriveTrainSpeed * Logic.plusNeg(Operator.getPitch()));
      }
      else{
        drivetrain.setUnlimitedAllDrive(Operator.getPitch() * 0.0625); //0.003125
      }
    }
    else{
      if(alternateButton2){
        drivetrain.setLeftDrive(-Operator.getRightJoystickY());
        drivetrain.setRightDrive(-Operator.getLeftJoystickY());
      }
      else{
        drivetrain.setLeftDrive(Operator.getLeftJoystickY());
        drivetrain.setRightDrive(Operator.getRightJoystickY());
      }
    }
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
