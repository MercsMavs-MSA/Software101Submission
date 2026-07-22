// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Transfer;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

 //gear ratio 1
public final class TransferConstants {
  public final static int TRANSFER_MOTOR_ID = 24;
  public final static double GEAR_RATIO = 1.0;
  public final static double kP = 0.21;
  public final static double kV = 0.15;
  public final static int Stator_Limiter = 60;
  public final static int Supply_Limiter = 40;
  public final static int Target_Velocity = 15;
}
