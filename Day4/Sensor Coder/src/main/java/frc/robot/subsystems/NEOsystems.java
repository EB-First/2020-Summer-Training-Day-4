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

public class NEOEncoder extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private Ultrasonic sensor = new Ultrasonic(0);
  private CANSparkMax motor = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANEncoder encoder = new CANEncoder(motor);
public NEOEncoder() {
   
  }
  public motorSpin() {
    motor.set(.5);
    }
  public motorStop() {
    motor.set(0);
    }
    public double getEncoder() {
      sensor.getPosition();
      while (encoder < 30) {
        execute(motorSpin());
        encoder++;
      }
      run.motorStop();
   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    ultrasonic.setAutomaticMode(true);
  }
}
