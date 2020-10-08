package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Encoder;

public class EncoderRun{
	public EncoderRun()
	{
		addRequirements(RobotContainer.m_Encoder);
	}
	@Override
	public void initialize() {
	}
	@Override
	public void execute() {
		RobotContainer.m_Encoder.run();
	}
	@Override
	public void end(){
		RobotContainer.m_Encoder.stop();
	}

}
