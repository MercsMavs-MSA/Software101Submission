package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public final class ArmConstants {
    //Key Info
    public final static int MOTOR_ID = 34;
    public final static double GEAR_RATIO = 36;

    //Feed Foward + PIDs
    public final static double KP = 55.0;
    public final static double KD = 0.0;
    public final static double KG = 0.0;

    //Positions
    public final static double UP_POS = 2.285;
    public final static double DOWN_POS = 0.005;

    //Current Limits
    public final static double MAX_STATOR_CURRENT = 80.0;
    public final static double MAX_SUPPLY_CURRENT = 20.0;

  }

}
