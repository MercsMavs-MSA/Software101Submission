// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static double intakeKP = 25;
  public static double intakeKV = 0;
  public static NeutralModeValue NeutralMode = NeutralModeValue.Brake;
  public static double currentLimit = 32.0;
  public static boolean currLimEnable = true;
  public static double statorLimit = 40.0;
  public static boolean statorLimEnable = true;
  public static double gearRatio = 24.0/1.0;
  public static InvertedValue invert = InvertedValue.CounterClockwise_Positive;

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
