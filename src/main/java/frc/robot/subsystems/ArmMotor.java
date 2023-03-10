package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;

public class ArmMotor extends SubsystemBase{
    private static ArmMotor armMotor;

    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;

    private PIDController armMotorController;
    private ArmFeedforward armFeedForward;

    private int direction = 1;
    private double input;

    
    private ArmMotor(){
        leftMotor = new CANSparkMax(Constants.LEFT_ARM_MOTOR, MotorType.kBrushless);
        rightMotor = new CANSparkMax(Constants.RIGHT_ARM_MOTOR, MotorType.kBrushless);

        armMotorController =  new PIDController(0.01, 0, 0);
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
        leftMotor.set(speed * 0.3);
        rightMotor.set(speed * 0.3);
    }

    public void setAutoArmMotor(double speed) {
        leftMotor.set(speed * 0.3);
        rightMotor.set(speed * 0.3);
    }

    // public void setArmMotorPID(double speed){
    //     input = armMotorController.calculate(leftMotor.getEncoder().getVelocity(), speed) + 
    //     armFeedForward.calculate();
    //     leftMotor.set(input);
    //     rightMotor.set(input);
    // }

    public double displayArmMotorVal(){
        return leftMotor.getEncoder().getVelocity();
    }

    public void setDirectionForward() {
        direction = 1;
    }

    public void setDirectionReverse() {
        direction = -1;
    }

    public int getDirection() {
        return direction;
    }
}
