/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class SensorSubsystem extends SubsystemBase {
  /**
   * Creates a new SensorSubsystem.
   */

  private CANSparkMax can;
  private CANEncoder encoder;
  private int countsToStop = 500;

  public SensorSubsystem() {
    can = new CANSparkMax(0, MotorType.kBrushless);
    encoder = new CANEncoder(can);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void getCounts() {
    if(encoder.getPosition() * encoder.getCountsPerRevolution() < countsToStop ) {
      can.set(1); 
    } else if(encoder.getPosition() * encoder.getCountsPerRevolution() >= countsToStop ) {
      can.set(0);
    }

  }

  public void stopMotors() {
    can.set(0);
  }
}
