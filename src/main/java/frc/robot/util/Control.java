package frc.robot.util;

import frc.robot.subsystems.ArmMotor;
import frc.robot.commands.Assistance.Balance;
import frc.robot.commands.Assistance.Stop;
import frc.robot.subsystems.ArmPiston;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Lights;
import frc.robot.commands.Control.ArmMotorControl;
import frc.robot.commands.Control.ArmPistonControl;
import frc.robot.commands.Control.ClawControl;
import frc.robot.commands.Control.DrivetrainControl;
import frc.robot.commands.Control.LightsControl;
import frc.robot.subsystems.Drivetrain;

import javax.net.ssl.TrustManager;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Control {
	private static CommandJoystick leftJoystick;
	private static CommandJoystick rightJoystick;
	private static CommandXboxController xboxController;

	private static Drivetrain drivetrain;
    private static ArmMotor armMotor;
    private static ArmPiston armPiston;
    private static Claw claw;
    private static Lights lights;

	public static void init() {
		leftJoystick = new CommandJoystick(Constants.LEFT_JOYSTICK);
        rightJoystick = new CommandJoystick(Constants.RIGHT_JOYSTICK);
        xboxController = new CommandXboxController(Constants.XBOX_CONTROLLER);

		drivetrain = Drivetrain.getInstance();
        armPiston = ArmPiston.getInstance();
        armMotor = ArmMotor.getInstance();
        claw = Claw.getInstance();
        lights = Lights.getInstance();
	}

    public static void setDefaultCommands() {

        // drivetrain.setDefaultCommand(new DrivetrainControl(leftJoystick.getY(), rightJoystick.getY()));
        // armMotor.setDefaultCommand(new ArmMotorControl(xboxController.getLeftY()));

        drivetrain.setDefaultCommand(new DrivetrainControl());
        // armMotor.setDefaultCommand(new ArmMotorControl());

        // armPiston.setDefaultCommand(new ArmPistonDefault());
        // claw.setDefaultCommand(new ClawDefault());
        new ArmMotorControl();
        armPiston.setArmPiston(false);
        claw.setClaw(false);
    }

	public static void configureBindings() {
        leftJoystick.trigger().toggleOnTrue(
            Commands.startEnd(drivetrain::setDirectionForward, drivetrain::setDirectionReverse, drivetrain)
        );

        xboxController.leftStick().toggleOnTrue(
            Commands.startEnd(armMotor::setDirectionForward, armMotor::setDirectionReverse, armMotor)
        );

        rightJoystick.trigger().whileTrue(new Balance());
        rightJoystick.button(2).whileTrue(new Stop());
        // leftJoystick.trigger().onTrue(new DrivetrainControl)

        xboxController.a().onTrue(new ClawControl(1));
        xboxController.y().onTrue(new ClawControl(0));

        // xboxController.b().onTrue(new ArmPistonControl(1));
        // xboxController.x().onTrue(new ArmPistonControl(0));

        // xboxController.y().toggleOnTrue(Commands.startEnd(armPiston::trueArmPiston, armPiston::falseArmPiston, armPiston));

        xboxController.leftBumper().and(xboxController.rightBumper()).toggleOnTrue(
            Commands.startEnd(armPiston::trueArmPiston, armPiston::falseArmPiston, armPiston)
        );
        // xboxController.leftBumper().and(xboxController.rightBumper()).onTrue(new ArmPistonControl(2, false));
        // xboxController.leftBumper().and(xboxController.rightBumper()).onTrue(new InstantCommand(() -> armPiston.toggleArmPiston()));

        // xboxController.rightStick().onTrue(new LightsControl(1, true));
        // xboxController.rightStick().onTrue(new LightsControl(2, true));
        // xboxController.rightStick().onTrue(new LightsControl(3, true));

        // xboxController.pov(0).onTrue(new LightsControl(1, false));
        // xboxController.pov(0).onTrue(new LightsControl(2, false));
        // xboxController.pov(0).onTrue(new LightsControl(3, false));

        // xboxController.pov(90).onTrue(new LightsControl(1, false));
        // xboxController.pov(90).onTrue(new LightsControl(2, true));
        // xboxController.pov(90).onTrue(new LightsControl(3, true));

        // xboxController.pov(180).onTrue(new LightsControl(1, true));
        // xboxController.pov(180).onTrue(new LightsControl(2, false));
        // xboxController.pov(180).onTrue(new LightsControl(3, true));

        // xboxController.pov(270).onTrue(new LightsControl(1, true));
        // xboxController.pov(270).onTrue(new LightsControl(2, true));
        // xboxController.pov(270).onTrue(new LightsControl(3, false));

        xboxController.rightStick().onTrue(new LightsControl(0));
        xboxController.pov(0).onTrue(new LightsControl(1));
        xboxController.pov(90).onTrue(new LightsControl(2));
        xboxController.pov(180).onTrue(new LightsControl(3));
        xboxController.pov(270).onTrue(new LightsControl(4));
    }

    public static double getLeftJoystickY() {
        return leftJoystick.getY();
    }
    // public static double getLeftThrottle() {
    //     return (0.5 * (1 - leftJoystick.getThrottle()));
    // }
    public static double getLeftThrottle() {
        return leftJoystick.getThrottle();
    }
    public static double getRightJoystickY() {
        return rightJoystick.getY();
    }
    public static double getRightThrottle() {
        return (0.5 * (1 - rightJoystick.getThrottle()));
    }

    public static double getLeftControllerJoystickY() {
        return xboxController.getLeftY();
    }
}
