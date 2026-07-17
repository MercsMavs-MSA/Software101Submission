// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class ArmConstants {
  //pid tuning
  public static double kP = 55.0;
  public static double kD = 0.0;
  public static double kG = 0.0;

  public static final double ARM_GEAR_RATIO = 36.0;
  public static final int ARM_MOTOR_ID = 34;

  public static final double ARM_SCORE_POS = 2.285;
  public static final double ARM_BACK_POS = 0.005;

  public static final double ARM_STATOR_LIMIT = 80.0;
  public static final double ARM_SUPPLY_LIMIT = 20.0;
}


