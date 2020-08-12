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
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

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

  public void Ultrasonic() {
    while()





    /*
    RobotContainer.m_NEOEncoder.stop();
     while(RobotContainer.m_NEOEncoder.getEncoder()== ENCODER_COUNTS) {
      RobotContainer.m_NEOEncoder.spin();
      */
     

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
