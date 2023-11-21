package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.TrapezoidProfileCommand;
import frc.robot.commands.Control.ArmMotorControl;
import frc.robot.util.Logic;

import static frc.robot.util.Constants.*;

public class ArmMotor extends SubsystemBase{
    private static ArmMotor armMotor;

    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;

    private DutyCycleEncoder encoder;

    // private PIDController armMotorDegreeController;
    private ProfiledPIDController armMotorDegreeController;
    private SimpleMotorFeedforward armFeedForward;

    private int direction = 1;
    private double input;
    private static TrapezoidProfile.Constraints constraints;
    
    private ArmMotor() {
        leftMotor = new CANSparkMax(LEFT_ARM_MOTOR, MotorType.kBrushless);
        rightMotor = new CANSparkMax(RIGHT_ARM_MOTOR, MotorType.kBrushless);

        encoder = new DutyCycleEncoder(ENCODER_1);

        constraints = new TrapezoidProfile.Constraints(0.00000000000000001, 0.000000000000001);

        // armMotorDegreeController =  new PIDController(4, 0, 1);
        armMotorDegreeController =  new ProfiledPIDController(0.005, 0, 0, constraints);
        armMotorDegreeController.setTolerance(0.01, 0.001);

        //not working
        armFeedForward = new SimpleMotorFeedforward(0.059774, 13.034, 0.62803);
    }

    public static ArmMotor getInstance() {
        if(armMotor == null){
            armMotor = new ArmMotor();
        }
        return armMotor;
    }

    public CANSparkMax getArmMotor() {
        return leftMotor;
    }

    public void setArmMotor(double speed) {
        leftMotor.set(0.5 * speed);
        rightMotor.set(0.5 * speed);
    }

    public void setAutoArmMotor(double speed) {
        leftMotor.set(speed);
        rightMotor.set(speed);
    }

    public void setInStabalizedArm(double speed) {
        leftMotor.set(speed + ARM_IN_SIN_CONSTANT * Logic.armStabalize(getArmMotorVal()));
        rightMotor.set(speed + ARM_IN_SIN_CONSTANT * Logic.armStabalize(getArmMotorVal()));
    }

    public void setOutStabalizedArm(double speed) {
        leftMotor.set(speed + ARM_OUT_SIN_CONSTANT * Logic.armStabalize(getArmMotorVal()));
        rightMotor.set(speed + ARM_OUT_SIN_CONSTANT * Logic.armStabalize(getArmMotorVal()));
    }

    public ProfiledPIDController getArmDegreeController() {
        return armMotorDegreeController;
    }

    public double getArmMotorVal(){
        if(encoder.getDistance() < 0.3){
            return encoder.getDistance() + 1; 
        }
        else {
            return encoder.getDistance();
        }
    }

    public boolean getEncoderThere() {
        return encoder.isConnected();
    }

    public SimpleMotorFeedforward getArmFeedForward() {
        return armFeedForward;
    }
}
