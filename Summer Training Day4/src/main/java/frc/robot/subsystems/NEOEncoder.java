/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NEOEncoder extends SubsystemBase {
  /**
   * Creates a new NEOEncoder.
   */

   private CANSparkMax motor;
   private CANEncoder encoder; 
   private Ultrasonic ultrasonic;

  public NEOEncoder() {
    motor = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
    encoder = new CANEncoder(motor);
    ultrasonic = new Ultrasonic(1,2);
  }

  public void spin() {
    motor.set(0.7);
  }

  public void stop() {
    motor.set(0);
  }

  public double getEncoder() {
    return encoder.getPosition();
  }
  
  public double getUltrasonic() {
    return ultrasonic.getRangeInches();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
