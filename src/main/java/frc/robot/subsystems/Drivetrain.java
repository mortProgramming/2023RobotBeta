package frc.robot.subsystems;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.SerialPort;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;
import frc.robot.util.Control;

public class Drivetrain extends SubsystemBase{
    private static Drivetrain drivetrain;
    private static AHRS ahrs;

    private CANSparkMax masterLeftTalon;
    private CANSparkMax masterRightTalon;
    private CANSparkMax followLeftTalon;
    private CANSparkMax followRightTalon;

    private PIDController stopPIDController;
    private PIDController balancePIDController;
    private PIDController turnPIDController;
    
    private Drivetrain() {
        masterLeftTalon = new CANSparkMax(Constants.MASTER_LEFT_TALON_PORT, MotorType.kBrushless);
        masterRightTalon = new CANSparkMax(Constants.MASTER_RIGHT_TALON_PORT, MotorType.kBrushless);
        followLeftTalon = new CANSparkMax(Constants.FOLLOW_LEFT_TALON_PORT, MotorType.kBrushless);
        followRightTalon = new CANSparkMax(Constants.FOLLOW_RIGHT_TALON_PORT, MotorType.kBrushless);

        followLeftTalon.follow(masterLeftTalon);
        followRightTalon.follow(masterRightTalon);

        ahrs = new AHRS(SerialPort.Port.kMXP);

        stopPIDController = new PIDController(0,0,0);

        turnPIDController = new PIDController(0.005, 0, 0);
        turnPIDController.setTolerance(1, 5);
        turnPIDController.enableContinuousInput(-180f, 180f);

        balancePIDController = new PIDController(0,0,0);
    }

    public static Drivetrain getInstance() {
        if(drivetrain == null){
            drivetrain = new Drivetrain();
        }
        return drivetrain;
    }

    public static float getRoll(){
        return ahrs.getRoll();
    }
    public static float getPitch(){
        return ahrs.getPitch();
    }
    public static double getYaw(){
        return ahrs.getYaw();
    }
    public static double getXVelocity(){
        return ahrs.getVelocityX();
    }
    public static double getYVelocity(){
        return ahrs.getVelocityY();
    }
    public static double getZVelocity(){
        return ahrs.getVelocityZ();
    }

    public void setLeftDrive(double speed) {
        masterLeftTalon.set(speed * Control.getLeftThrottle());
    }
    public void setRightDrive(double speed) {
        masterRightTalon.set(speed * Control.getLeftThrottle());
    }
    public void setAllDrive(double speed) {
        masterLeftTalon.set(speed * Control.getLeftThrottle());
        masterRightTalon.set(speed * Control.getLeftThrottle());
    }
    public void setStop(){
        masterLeftTalon.set(0);
        masterRightTalon.set(0);
    }
    public void setPIDStop(){
        masterLeftTalon.set(stopPIDController.calculate(Drivetrain.getXVelocity(),0));
        masterRightTalon.set(stopPIDController.calculate(Drivetrain.getXVelocity(),0));
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
    public void setBalanceDrivetrain(){
        masterLeftTalon.set(balancePIDController.calculate(Drivetrain.getPitch(),0));
        masterRightTalon.set(balancePIDController.calculate(Drivetrain.getPitch(),0));
    }
    public void setTurnPID(double degrees, double oldYaw){
        masterLeftTalon.set(turnPIDController.calculate(Drivetrain.getYaw(), (degrees + oldYaw)));
        masterRightTalon.set(turnPIDController.calculate(Drivetrain.getYaw(), (degrees + oldYaw)));
    }
     public boolean turnSetpoint(){
        return turnPIDController.atSetpoint();
     }
}
