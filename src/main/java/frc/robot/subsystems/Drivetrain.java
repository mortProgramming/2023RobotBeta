package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Operator;

public class Drivetrain extends SubsystemBase{
    private static Drivetrain drivetrain;

    private CANSparkMax masterLeftTalon;
    private CANSparkMax masterRightTalon;
    private CANSparkMax followLeftTalon;
    private CANSparkMax followRightTalon;
    
    private Drivetrain() {
        masterLeftTalon = new CANSparkMax(Constants.MASTER_LEFT_TALON_PORT, MotorType.kBrushless);
        masterRightTalon = new CANSparkMax(Constants.MASTER_RIGHT_TALON_PORT, MotorType.kBrushless);
        followLeftTalon = new CANSparkMax(Constants.FOLLOW_LEFT_TALON_PORT, MotorType.kBrushless);
        followRightTalon = new CANSparkMax(Constants.FOLLOW_RIGHT_TALON_PORT, MotorType.kBrushless);

        followLeftTalon.follow(masterLeftTalon);
        followRightTalon.follow(masterRightTalon);
    }

    public static Drivetrain getInstance() {
        if(drivetrain == null){
            drivetrain = new Drivetrain();
        }
        return drivetrain;
    }
    public void setLeftDrive(double speed) {
        masterLeftTalon.set(speed * Operator.getLeftThrottle());
    }
    public void setRightDrive(double speed) {
        masterRightTalon.set(speed * Operator.getLeftThrottle());
    }
    public void setAllDrive(double speed) {
        masterLeftTalon.set(speed * Operator.getLeftThrottle());
        masterRightTalon.set(speed * Operator.getLeftThrottle());
    }
    public void setStop(){
        masterLeftTalon.set(0);
        masterRightTalon.set(0);
    }
    public void setUnlimitedLeftDrive(double speed) {
        masterLeftTalon.set(speed);
    }
    public void setUnlimitedRightDrive(double speed) {
        masterRightTalon.set(speed);
    }
    public void setUnlimitedAllDrive(double speed) {
        masterLeftTalon.set(speed);
        masterRightTalon.set(speed);
    }
}
