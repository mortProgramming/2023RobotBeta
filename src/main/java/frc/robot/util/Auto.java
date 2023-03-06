package frc.robot.util;

import java.util.HashMap;

import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.RamseteAutoBuilder;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;

import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.Auton.LBlue;
import frc.robot.commands.Auton.MBlue;
import frc.robot.commands.Auton.RBlue;
import frc.robot.commands.Called.ScorePiece;
import frc.robot.commands.TestAuton.Tester1;
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
		// autoChooser.setDefaultOption("nothing", null);
		// autoChooser.addOption("Square", new Square());
		// autoChooser.setDefaultOption("HoldPiece", new HoldPiece());
		autoChooser.setDefaultOption("Tester", new Tester1());
		autoChooser.addOption("RBlue", new RBlue());
		autoChooser.addOption("MBlue", new MBlue());
		autoChooser.addOption("LBlue", new LBlue());
		// autoChooser.setDefaultOption("Test", autoFromPathGroup("Test"));
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
