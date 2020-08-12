/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SensorSubsystem extends SubsystemBase {
  /**
   * Creates a new SensorSubsystem.
   */

   private CANSparkMax can;
   private Ultrasonic ultrasonic;
   private CANEncoder encoder;

  public SensorSubsystem() {
    can = new CANSparkMax(Constants.CAN_PORT, MotorType.kBrushless);
    ultrasonic = new Ultrasonic(Constants.ULTRASONIC_PORT_1, Constants.ULTRASONIC_PORT_2);
    encoder = new CANEncoder(can);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMotorOff() { // kills power to motor
    can.set(Constants.MOTOR_OFF);
  }

  public double calulateDistance() { // calculate the distance from the robot to the nearest obstacle
    ultrasonic.setAutomaticMode(true);
    return ultrasonic.getRangeInches();
  }

  public int determineTicks(double distance) { // determine ticks needed to reach the distance given by the ultrasonic sensor
    int ticks;
    ticks = (int)(distance * (1/(2*Constants.WHEEL_RADIUS*Math.PI)) * (Constants.ENCODER_RESOLUTION));
    return ticks;
  }

  public int currentTicks() { // determine the current amount of ticks that have occured, updated in the periodic function of the command
    int currentTicks = ((int)encoder.getPosition() * encoder.getCountsPerRevolution());
    return (currentTicks);
  }

  public void driveToDistance(int ticks, int currentTicks) { // logic that determines if the robot has reached its target

    if(currentTicks < ticks) {
      can.set(Constants.MOTOR_ON);
    } else if(currentTicks >= ticks) {
      can.set(Constants.MOTOR_OFF);
    }
  }
}
