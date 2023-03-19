package frc.robot.util;

import java.util.HashMap;

import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.RamseteAutoBuilder;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;

import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.Auton.Balance;
import frc.robot.commands.Auton.PieceBalance;
import frc.robot.commands.Auton.PieceTaxi;
import frc.robot.commands.Auton.ScoreTaxiBalance;
import frc.robot.commands.Called.Score;
import frc.robot.commands.Called.Taxi;
import frc.robot.commands.TestAuton.Tester1;
import frc.robot.commands.TestAuton.Tester2;
import frc.robot.commands.TestAuton.Tester3;
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
		autoChooser.setDefaultOption("nothing", null);
		autoChooser.addOption("JustPiece", new Score());
		autoChooser.addOption("JustTaxi", new Taxi());
		autoChooser.addOption("JustBalance", new Balance());
		autoChooser.addOption("PieceTaxi", new PieceTaxi());
		autoChooser.addOption("PieceBalance", new PieceBalance());
		autoChooser.addOption("Tester1", new Tester1());
		autoChooser.addOption("Tester2", new Tester2());
		autoChooser.addOption("Tester3", new Tester3());
		autoChooser.addOption("ScoreTaxiBalance", new ScoreTaxiBalance());
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
