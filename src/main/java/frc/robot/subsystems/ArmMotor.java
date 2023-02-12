package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;

public class ArmMotor extends SubsystemBase{
    
    private static ArmMotor armMotor;
    private CANSparkMax motor;
    private PIDController armMotorController;

    
    private ArmMotor(){
        motor = new CANSparkMax(Constants.ARM_MOTOR, MotorType.kBrushless);
        armMotorController =  new PIDController(0.0125, 0, 0);
    }

    public static ArmMotor getInstance() {
        if(armMotor == null){
            armMotor = new ArmMotor();
        }
        return armMotor;
    }

    public void setArmMotor(double speed) {
        motor.set(speed);
    }

    public void setArmMotorPID(double speed){
        motor.setVoltage(armMotorController.calculate(motor.getEncoder().getVelocity(), speed));
    }

    public double displayArmMotorVal(){
        return motor.getEncoder().getVelocity();
    }
}
