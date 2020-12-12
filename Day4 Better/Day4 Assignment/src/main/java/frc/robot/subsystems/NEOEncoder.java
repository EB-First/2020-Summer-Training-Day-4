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
 
 
public class NEOEncoder extends SubsystemBase {
 /**
  * Creates a new NEOEncoder.
  */
 
  private CANSparkMax motor1;
  private CANEncoder encoder;
  private Ultrasonic ultrasonic;
 
 
 public NEOEncoder() {
   motor1 = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
   encoder = new CANEncoder(motor1);
   ultrasonic = new Ultrasonic(1,2);
 }
 
 public motorStop() {
    motor1.set(0);
  }
  public motorMove() {
    motor1.set(.5);
  }
  public motorBack() {
    motor1.set(-.5);
  }
  public radius() {
    int radius = 5;
  }
  public double position() {
    ultrasonic.getPosition();

  }
 
 public void traveling() {
   while(encoder.getPosition()*1024<ultrasonic.getRangeInches()*(1024/2*Math.PI*5)) {   
     motor1.set(1);
   }
   motor1.set(0);
 }
 

 
 
 @Override
 public void periodic() {
   // This method will be called once per scheduler run
 }
}
