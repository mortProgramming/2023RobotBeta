package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Control.ArmMotorControl;
import static frc.robot.util.Constants.*;

public class ArmMotor extends SubsystemBase{
    private static ArmMotor armMotor;

    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;

    private DutyCycleEncoder encoder;

    private PIDController armMotorDegreeController;
    private SimpleMotorFeedforward armFeedForward;

    private int direction = 1;
    private double input;

    
    private ArmMotor() {
        leftMotor = new CANSparkMax(LEFT_ARM_MOTOR, MotorType.kBrushless);
        rightMotor = new CANSparkMax(RIGHT_ARM_MOTOR, MotorType.kBrushless);

        encoder = new DutyCycleEncoder(ENCODER_1);

        armMotorDegreeController =  new PIDController(8, 0.5, 0);
        armMotorDegreeController.setTolerance(0.05);

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

    public PIDController getArmDegreeController() {
        return armMotorDegreeController;
    }

    public double getArmMotorVal(){
        return encoder.getDistance();
    }

    public boolean getEncoderThere() {
        return encoder.isConnected();
    }

    public SimpleMotorFeedforward getArmFeedForward() {
        return armFeedForward;
    }
    // public void setDirectionForward() {
    //     armMotor.setDefaultCommand(new ArmMotorControl(1));
    // }

    // public void setDirectionReverse() {
    //     armMotor.setDefaultCommand(new ArmMotorControl(-1));
    // }
}
