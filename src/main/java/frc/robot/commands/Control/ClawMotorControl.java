package frc.robot.commands.Control;
import frc.robot.subsystems.ClawMotor;
import frc.robot.util.Logic;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.util.Constants.*;

public class ClawMotorControl extends CommandBase {
  ClawMotor clawMotor;

  public double speed;

  public ClawMotorControl(double speed) {
    this.speed = speed;

    clawMotor = ClawMotor.getInstance(); 

    addRequirements(clawMotor);
  }

  public void initialize() {
    clawMotor.setClawMotor(speed);
  }

  public void execute() {
    clawMotor.setClawMotor(speed);
  }

  public boolean isFinished() {
    return true;
  }
}
