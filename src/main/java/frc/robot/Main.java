package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

// starts the robot
public final class Main {
private Main() {}

  public static void main(String... args) {
// dont put stuff here
RobotBase.startRobot(Robot::new);
  }
}
