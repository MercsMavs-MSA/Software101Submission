// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package first.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final int WHEEL_MOTOR_ID = 1;
  public static final double  WHEEL_KP = .1;
  public static final double WHEEL_KI = 0;
  public static final double  WHEEL_KD = 0;
  public static final double[] WHEEL_FEEDFORWARD = { 0 , 0, 0,0 }; // S, V, A , G
  public static final double WHEEL_SPIN_VEL = .7;
  public static final double SPINDEXER_GEAR_RATIO = 1;
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    
  }
}
