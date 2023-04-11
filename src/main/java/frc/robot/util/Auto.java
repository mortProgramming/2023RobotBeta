package frc.robot.util;

import java.util.HashMap;

import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.RamseteAutoBuilder;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;

import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.Auton.JustBalance;
import frc.robot.commands.Auton.PieceBalance;
import frc.robot.commands.Auton.PieceTaxi;
import frc.robot.commands.Auton.Cone.ConeBalance;
import frc.robot.commands.Auton.Cone.ConeTaxi;
import frc.robot.commands.Auton.Cone.ConeTaxiBalance;
import frc.robot.commands.Auton.Cone.LeftConeTaxiGrab;
import frc.robot.commands.Auton.Cube.HighCubeBalance;
import frc.robot.commands.Auton.Cube.HighCubeTaxi;
import frc.robot.commands.Auton.TestAuton.Tester1;
import frc.robot.commands.Auton.TestAuton.Tester2;
import frc.robot.commands.Auton.TestAuton.Tester3;
import frc.robot.commands.Called.Arm.ConeScore;
import frc.robot.commands.Called.Arm.CubeScore;
import frc.robot.commands.Called.Arm.HighCubeScore;
import frc.robot.commands.Called.Drivetrain.Taxi;
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
		autoChooser.addOption("JustCone", new ConeScore());
		autoChooser.addOption("JustCube", new CubeScore());
		autoChooser.addOption("JustTaxi", new Taxi());
		autoChooser.addOption("JustBalance", new JustBalance());
		// autoChooser.addOption("PieceTaxi", new PieceTaxi());
		// autoChooser.addOption("PieceBalance", new PieceBalance());
		autoChooser.addOption("ConeTaxi", new ConeTaxi());
		autoChooser.addOption("ConeBalance", new ConeBalance());
		// autoChooser.addOption("LeftConeTaxiGrab", new LeftConeTaxiGrab());
		autoChooser.addOption("JustHighCube", new HighCubeScore());
		autoChooser.addOption("HighCubeTaxi", new HighCubeTaxi());
		autoChooser.addOption("HighCubeBalance", new HighCubeBalance());
		// autoChooser.addOption("Tester1", new Tester1());
		// autoChooser.addOption("Tester2", new Tester2());
		// autoChooser.addOption("Tester3", new Tester3());
		// autoChooser.addOption("ConeTaxiBalance", new ConeTaxiBalance());
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
