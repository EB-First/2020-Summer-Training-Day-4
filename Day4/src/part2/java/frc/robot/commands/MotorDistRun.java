package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.MotorDist;

public class MotorDistRun{
	public MotorDistRun()
	{
		addRequirements(RobotContainer.m_MotorDist);
	}
	@Override
	public void initialize() {
	}
	@Override
	public void execute() {
		RobotContainer.m_MotorDist.run();
	}
	@Override
	public void end(){
		RobotContainer.m_MotorDist.stop();
	}
	@Override
  	public boolean isFinished() {
    		return false;
  	}
}
