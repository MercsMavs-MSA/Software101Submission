// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.arm;

import com.ctre.phoenix6.signals.InvertedValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class SpindexerConstants {
  public static InvertedValue INVERTED = InvertedValue.Clockwise_Positive;
  public static double GEAR_RATIO = 10.0;
  public static double SPINDEXER_KV = 1.1;
  public static int SPINDEXER_MOTOR_ID = 43;
  public static int SUPPLY_LIMIT = 40;
  public static int STATOR_LIMIT = 80;
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
