// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Control.ArmMotorControl;
import frc.robot.commands.Control.DrivetrainControl;
import frc.robot.subsystems.ArmMotor;
import frc.robot.subsystems.ArmPiston;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;
import frc.robot.util.Auto;
import frc.robot.util.Control;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import static frc.robot.util.Constants.*;
import frc.robot.subsystems.PneumaticsHub;

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
  private final ArmMotor armMotor;
  private final ArmPiston armPiston;
  private final Claw claw;
  private final PneumaticsHub pneumaticsHub;

  // private final Compressor compressor;

  public RobotContainer() {
    // compressor = new Compressor(PNEUMATIC_PORT, PneumaticsModuleType.REVPH);

    // compressor.enableDigital();
  
    Control.init();

    drivetrain = Drivetrain.getInstance();
    armMotor = ArmMotor.getInstance();
    armPiston = ArmPiston.getInstance();
    claw = Claw.getInstance();
    pneumaticsHub = PneumaticsHub.getInstance();

    pneumaticsHub.setCompressorDigital();

    Control.setDefaultCommands();

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
