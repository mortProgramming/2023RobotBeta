package frc.robot.util;

import frc.robot.commands.Teleop.Balance;
import frc.robot.commands.Teleop.Stop;
import frc.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Control {
	private static CommandJoystick leftJoystick;
	private static CommandJoystick rightJoystick;
	private static CommandXboxController xboxController;

	private static Drivetrain drivetrain;

	public static void init() {
		leftJoystick = new CommandJoystick(Constants.LEFT_JOYSTICK);
        rightJoystick = new CommandJoystick(Constants.RIGHT_JOYSTICK);
        xboxController = new CommandXboxController(Constants.XBOX_CONTROLLER);

		drivetrain = Drivetrain.getInstance();
	}
	public static void configureBindings() {
        rightJoystick.trigger().toggleOnTrue(new Balance());
        rightJoystick.button(2).toggleOnTrue(new Stop());
    }

    public static double getLeftJoystickY() {
        return leftJoystick.getY();
    }
    public static double getLeftThrottle() {
        return (0.5 * (1 - leftJoystick.getThrottle()));
    }
    public static double getRightJoystickY() {
        return rightJoystick.getY();
    }
    public static double getRightThrottle() {
        return (0.5 * (1 - rightJoystick.getThrottle()));
    }
}
