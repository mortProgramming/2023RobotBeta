package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.util.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ClawMotor extends SubsystemBase{
    private static ClawMotor clawMotor;

    private static CANSparkMax leftMotor;
    private static CANSparkMax rightMotor;

    private ClawMotor() {
        leftMotor = new CANSparkMax(LEFT_CLAW_MOTOR, MotorType.kBrushless);
        rightMotor = new CANSparkMax(RIGHT_CLAW_MOTOR, MotorType.kBrushless);
    }
    
    public static ClawMotor getInstance() {
        if(clawMotor == null){
            clawMotor = new ClawMotor();
        }
        return clawMotor;
    }

    public void setClawMotor(double setting) {
        leftMotor.set(-setting);
        rightMotor.set(setting);
    }
}
