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


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NEOEncoder extends SubsystemBase {
  /**
   * Creates a new NEOEncoder.
   */

   private CANSparkMax motor = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
   public CANEncoder encoder = new CANEncoder(motor);

  public NEOEncoder() {
    
    
  }

  public void Spin() {
    motor.set(0.7);
  }

  public void Go() {
    motor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
