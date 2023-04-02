package frc.robot.commands.Called.Arm;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.Control.ArmMotorControl;
import frc.robot.subsystems.ArmMotor;

public class TimedArm extends CommandBase{
    ArmMotor armMotor;

    private double speed;
    private double time;

    private Timer timer = new Timer();

    public TimedArm(double time, double speed) {
        this.time = time;
        this.speed = speed;

        armMotor = ArmMotor.getInstance();

        addRequirements(armMotor);
    }

    public void initialize() {
        timer.reset();
        timer.start();
        armMotor.setAutoArmMotor(speed);
    }

    public void execute() {
        armMotor.setAutoArmMotor(speed);
    }

    public boolean isFinished() {
        return timer.get() > time;
    }

    public void end(boolean interupted){
        armMotor.setAutoArmMotor(0);
    }
}
