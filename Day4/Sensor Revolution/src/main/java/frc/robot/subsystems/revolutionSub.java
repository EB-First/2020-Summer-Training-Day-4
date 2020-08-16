/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Ultrasonic;

public class revolutionSub extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private CANSparkMax mainMotor = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
  private Ultrasonic sensor = new Ultrasonic(0);
  private CANEncoder encoder = new CANEncoder(motorR);
  public revolutionSub() {

  }
  public motorStop() {
    mainMotor.set(0);
  }
  public motorMove() {
    mainMotor.set(.5);
  }
  public motorBack() {
    mainMotor.set(-.5);
  }
  public radius() {
    int radius = 5;
  }
  public double position() {
    sensor.getPosition();
  }
  public int getCount() {
    count = position() * (1/(2*Math.PI*radius())) * (1024/1);
    return count;
  }
  public void runPosition() {
    if (getCount()*encoder.getCountsPerRevolution() < position()) {
     motorMove();
    } else if (getCount()*encoder.getCountsPerRevolution() >= position()) {
      motorStop();
    }
  }
    @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
