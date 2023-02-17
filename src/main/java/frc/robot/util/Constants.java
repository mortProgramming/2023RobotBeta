// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.util;

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
  
  public static final int MASTER_LEFT_TALON_PORT = 10;
  public static final int FOLLOW_LEFT_TALON_PORT = 9;
  public static final int MASTER_RIGHT_TALON_PORT = 4;
  public static final int FOLLOW_RIGHT_TALON_PORT = 5;

  public static final int PNEUMATIC_PORT = 10;
  public static final int COMPRESSER_MIN_PRESSURE = 80;
  public static final int COMPRESSER_MAX_PRESSURE = 120;

  //dsacco10@gmail.com

  // not sure abt these ports yet!!!
  public static final int OPEN_ARM_PISTON = 1;
  public static final int CLOSE_ARM_PISTON = 2;

  public static final int ARM_MOTOR = 8;

  public static final int OPEN_CLAW_PISTON = 8;
  public static final int CLOSE_CLAW_PISTON = 9;
}
