package frc.robot;

// dont put code in here just numbers
public final class Constants {
private Constants() {}

  // port for the xbox thing
  public static final int DRIVER_CONTROLLER_PORT = 0;

  // can id might be wrong idk
  public static final int ARM_MOTOR_ID = 1;

  // pid stuff from the tuner i think
  public static final double ARM_KP = 0.0;
  public static final double ARM_KI = 0.0;
  public static final double ARM_KD = 0.0;

  // were the arm goes when you press A
  public static final double ARM_TARGET_POSITION = 0.5;

  // so the motor dont melt
  public static final double ARM_STATOR_CURRENT_LIMIT = 80;
  public static final double ARM_SUPPLY_CURRENT_LIMIT = 60;
}
