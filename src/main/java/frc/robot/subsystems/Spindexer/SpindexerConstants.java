// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Spindexer;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class SpindexerConstants {
  public final static int MOTOR_ID = 25;
  public final static double GEAR_RATIO = 3.0;
  public final static double kP = 0.4000000059604645;
  public final static double kV = 0.15000000596046448;
  public final static double STATOR_LIMIT = 60.0;
  public final static double SUPPLY_LIMIT = 30.0;
  public final static double SPINDEXER_VELOCITY = 15.0;
}
