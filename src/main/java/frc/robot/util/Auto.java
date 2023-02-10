package frc.robot.util;

import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.Auton.Square;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto {
	private static Drivetrain drivetrain;

	private static SendableChooser<Command> autoChooser;

	public static void init() {
		drivetrain = Drivetrain.getInstance();

		autoChooser = new SendableChooser<Command>();
		addAutoOptions();

		// put the auto chooser onto SmartDashboard
		SmartDashboard.putData(autoChooser);
	}

	public static void addAutoOptions() {
		// By default, the nothing option is selected
		autoChooser.setDefaultOption("nothing", null);
		autoChooser.addOption("Square", new Square());
	}

	/**
	 * @return selected auto from auto chooser
	 */
	public static Command getSelected() {
		return autoChooser.getSelected();
	}
}
