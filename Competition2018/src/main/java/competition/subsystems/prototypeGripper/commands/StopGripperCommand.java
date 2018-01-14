package competition.subsystems.prototypeGripper.commands;

import com.google.inject.Inject;

import competition.subsystems.prototypeGripper.PrototypeGripperSubsystem;

public class StopGripperCommand extends BaseProtoGripperCommand {
	
	@Inject
	public StopGripperCommand(PrototypeGripperSubsystem gripper) {
		super(gripper);
		// TODO Auto-generated constructor stub
		this.requires(gripper);
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		gripper.stopIntake();
		
	}

}
