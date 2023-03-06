package frc.robot.subsystems;
import java.util.function.BiConsumer;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.SerialPort;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.Constants;
import frc.robot.util.Control;

import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;

public class Drivetrain extends SubsystemBase{
    private static Drivetrain drivetrain;
    private static AHRS ahrs;

    private CANSparkMax masterLeftTalon;
    private CANSparkMax masterRightTalon;
    private CANSparkMax followLeftTalon;
    private CANSparkMax followRightTalon;

    private DifferentialDriveOdometry odometry;
    private Pose2d pose2d;

    public DifferentialDriveKinematics driveKinematics;

    private PIDController stopController;
    private PIDController balanceController;
    private PIDController turnController;

    private double direction;
    
    private Drivetrain() {
        masterLeftTalon = new CANSparkMax(Constants.MASTER_LEFT_TALON, MotorType.kBrushless);
        masterRightTalon = new CANSparkMax(Constants.MASTER_RIGHT_TALON, MotorType.kBrushless);
        followLeftTalon = new CANSparkMax(Constants.FOLLOW_LEFT_TALON, MotorType.kBrushless);
        followRightTalon = new CANSparkMax(Constants.FOLLOW_RIGHT_TALON, MotorType.kBrushless);

        followLeftTalon.follow(masterLeftTalon);
        followRightTalon.follow(masterRightTalon);

        ahrs = new AHRS(SerialPort.Port.kMXP);

        driveKinematics = new DifferentialDriveKinematics(0.8);

        pose2d = new Pose2d();

        odometry = new DifferentialDriveOdometry(ahrs.getRotation2d(), 
                masterLeftTalon.getEncoder().getPosition(), masterRightTalon.getEncoder().getPosition(),
                pose2d
        );

        stopController = new PIDController(0,0,0);

        turnController = new PIDController(0.005, 0, 0);
        turnController.setTolerance(1, 5);
        turnController.enableContinuousInput(-180f, 180f);

        balanceController = new PIDController(0.01,0,0.01);
        balanceController.setTolerance(2.5, 0);
        balanceController.setSetpoint(0);
    }

    public static Drivetrain getInstance() {
        if(drivetrain == null){
            drivetrain = new Drivetrain();
        }
        return drivetrain;
    }

    public Pose2d getPose() {
		return odometry.getPoseMeters();
	}

    public void resetPose(Pose2d pose) {
		odometry.resetPosition(ahrs.getRotation2d(), masterLeftTalon.getEncoder().getPosition(), masterRightTalon.getEncoder().getPosition(), pose);
	}

    public AHRS ahrs() {
        return ahrs;
    }

    public static double getRoll() {
        return ahrs.getRoll();
    }
    
    public static double getPitch() {
        return ahrs.getPitch();
    }
    
    public static double getYaw() {
        return ahrs.getYaw();
    }
    
    public static double getXVelocity() {
        return ahrs.getVelocityX();
    }
    
    public static double getYVelocity() {
        return ahrs.getVelocityY();
    }
    
    public static double getZVelocity() {
        return ahrs.getVelocityZ();
    }


    public CANSparkMax getLeftDrive() {
        return masterLeftTalon;
    }

    public CANSparkMax getRightDrive() {
        return masterRightTalon;
    }
    
    public void setDrive(double leftMotorSpeed, double rightMotorSpeed) {
        masterLeftTalon.set(-leftMotorSpeed * Control.getLeftThrottle());
        masterRightTalon.set(-rightMotorSpeed * Control.getLeftThrottle());
    }
    
    public void setFullDrive(double leftMotorSpeed, double rightMotorSpeed) {
        masterLeftTalon.set(leftMotorSpeed);
        masterRightTalon.set(rightMotorSpeed);
    }

    public void setDirectionForward() {
        direction = 1;
    }

    public void setDirectionReverse() {
        direction = -1;
    }

    public double getDirection() {
        return direction;
    }
    
    public PIDController getBalanceController() {
        return balanceController;
    }

    public PIDController getStopController() {
        return stopController;
    }

    public PIDController getTurnController() {
        return turnController;
    }
    
    public void setTurnPID(double degrees, double oldYaw) {
        masterLeftTalon.set(turnController.calculate(Drivetrain.getYaw(), (degrees + oldYaw)));
        masterRightTalon.set(turnController.calculate(Drivetrain.getYaw(), (degrees + oldYaw)));
    }
    
    public boolean turnSetpoint() {
        return turnController.atSetpoint();
     }
}
