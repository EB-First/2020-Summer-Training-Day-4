package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import frc.robot.Constants;

public class MotorDist extends SubsystemBase{
	private CANSparkMax motor = new CANSparkMax(Constants.MOTOR_PORT,CANSparkMaxLowLevel.MotorType.kBrushless);
	private CANEncoder enc = new CANEncoder(motor);
	private Ultrasonic dist = new Ultrasonic(Constants.US_PORT_1,Constants.US_PORT_2);
	private int encCt;
	public Encoder(){
		dist.setAutomaticMode(true);
	}
	public void run(){
		encCt = dist.getRangeInches()/(2*Constants.RD*Math.PI)*enc.getCountsPerRevolution();
		enc.setPosition(0);
		while(enc.getPosition()<encCt)
		{
			motor.set(1);
		}
	}
	public void stop(){
		motor.set(0);
	}
}
