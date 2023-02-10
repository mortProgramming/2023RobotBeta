// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.Auton.Square;

import frc.robot.subsystems.Drivetrain;
import frc.robot.util.Auto;
import frc.robot.util.Control;
import frc.robot.commands.Teleop.DrivetrainCommand;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Objects
  private final Drivetrain drivetrain;

  // private final Compressor compressor;

  public RobotContainer() {
    //
    Control.init();

    drivetrain = Drivetrain.getInstance();

    //compressor = new Compressor(Constants.PNEUMATIC_PORT, PneumaticsModuleType.REVPH);

    // compressor.enableAnalog(Constants.COMPRESSER_MIN_PRESSURE, Constants.COMPRESSER_MAX_PRESSURE);

    drivetrain.setDefaultCommand(new DrivetrainCommand());

    // Configure the button bindings
    Control.configureBindings();

    Auto.init();
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return Auto.getSelected();
  }
}
