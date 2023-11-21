// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

import edu.wpi.first.math.trajectory.TrapezoidProfile;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final int LEFT_JOYSTICK = 0;
  public static final int RIGHT_JOYSTICK = 1;
  public static final int XBOX_CONTROLLER = 2;
  
  public static final int MASTER_LEFT_TALON = 4;
  public static final int FOLLOW_LEFT_TALON = 3;
  public static final int MASTER_RIGHT_TALON = 1;
  public static final int FOLLOW_RIGHT_TALON = 2;

  public static final int LIGHT_1 = 1;
  public static final int LIGHT_2 = 2;
  public static final int LIGHT_3 = 3;

  public static final int ENCODER_1 = 8;

  public static final int PNEUMATIC_PORT = 10;
  public static final int COMPRESSER_MIN_PRESSURE = 100;
  public static final int COMPRESSER_MAX_PRESSURE = 120;

  //dsacco10@gmail.com

  public static final int PDH = 10;

  public static final int OPEN_ARM_PISTON = 1;
  public static final int CLOSE_ARM_PISTON = 2;

  public static final int LEFT_ARM_MOTOR = 5;
  public static final int RIGHT_ARM_MOTOR = 6;

  public static final int OPEN_CLAW_PISTON = 8;
  public static final int CLOSE_CLAW_PISTON = 9;

  public static final int LEFT_CLAW_MOTOR = 7;
  public static final int RIGHT_CLAW_MOTOR = 8;

  public static final double ARM_MOTOR_ENCODER_TO_0_DEGREES = -0.8;
  public static final double ARM_IN_SIN_CONSTANT = -0.05;
  public static final double ARM_OUT_SIN_CONSTANT = -0.06;
  public static final double ARM_POSITION_TO_DEGREES = 340;


  public static final double DEAD_BAND = 0.03;
  public static final double MIN_THROTTLE = 0;
  public static final double MAX_THROTTLE = 1;
  public static final double LOW_SENSITIVITY = 0.3;


  public static final TrapezoidProfile.Constraints constraints = new TrapezoidProfile.Constraints(0.00000000000000001, 0.000000000000001);
}
