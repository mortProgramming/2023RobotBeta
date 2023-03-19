package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Control.ArmMotorControl;
import static frc.robot.util.Constants.*;

public class ArmMotor extends SubsystemBase{
    private static ArmMotor armMotor;

    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;

    private Encoder encoder;

    private PIDController armMotorDegreeController;
    private ArmFeedforward armFeedForward;

    private int direction = 1;
    private double input;

    
    private ArmMotor() {
        leftMotor = new CANSparkMax(LEFT_ARM_MOTOR, MotorType.kBrushless);
        rightMotor = new CANSparkMax(RIGHT_ARM_MOTOR, MotorType.kBrushless);

        encoder = new Encoder(ENCODER_1, ENCODER_2, false, Encoder.EncodingType.k4X);

        armMotorDegreeController =  new PIDController(0.0001, 0, 0);
        armMotorDegreeController.setTolerance(1);

        armFeedForward = new ArmFeedforward(0, 0, 0, 0);
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
        leftMotor.set(speed * 0.5);
        rightMotor.set(speed * 0.5);
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

    // public void setDirectionForward() {
    //     armMotor.setDefaultCommand(new ArmMotorControl(1));
    // }

    // public void setDirectionReverse() {
    //     armMotor.setDefaultCommand(new ArmMotorControl(-1));
    // }
}
