package frc.robot.util;

import java.util.HashMap;

import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.RamseteAutoBuilder;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;

import frc.robot.subsystems.Drivetrain;
// import frc.robot.commands.Auton.Square;
import frc.robot.commands.Auton.HoldPiece;
import edu.wpi.first.math.controller.RamseteController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Auto {
	private static RamseteAutoBuilder autoBuilder;

	private static Drivetrain drivetrain;

	private static HashMap<String, Command> eventMap;

	private static SendableChooser<Command> autoChooser;

	public static void init() {
		eventMap = new HashMap<String, Command>();
		addEvents();

		drivetrain = Drivetrain.getInstance();

		autoBuilder = new RamseteAutoBuilder(
			drivetrain::getPose, 
			drivetrain::resetPose, 
			new RamseteController(), 
			drivetrain.driveKinematics, 
			drivetrain::setFullDrive, 
			eventMap, 
			drivetrain
		);

		autoChooser = new SendableChooser<Command>();
		addAutoOptions();

		// put the auto chooser onto SmartDashboard
		SmartDashboard.putData(autoChooser);
	}

	public static void addAutoOptions() {
		// By default, the nothing option is selected
		// autoChooser.setDefaultOption("nothing", null);
		// autoChooser.addOption("Square", new Square());
		autoChooser.setDefaultOption("HoldPiece", new HoldPiece());
		// autoChooser.addOption("Test", autoFromPathGroup("Test"));
	}

	public static CommandBase autoFromPathGroup(String name) {
		return autoBuilder.fullAuto(PathPlanner.loadPathGroup(name, new PathConstraints(0.5, 0.5)));
	}

	/**
	 * @return selected auto from auto chooser
	 */
	public static Command getSelected() {
		return autoChooser.getSelected();
	}

	public static void addEvents() {
		eventMap.put(null, null);
    }
}
