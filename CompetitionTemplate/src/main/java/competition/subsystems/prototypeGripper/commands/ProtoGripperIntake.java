package competition.subsystems.prototypeGripper.commands;

import com.google.inject.Inject;

import competition.subsystems.prototypeGripper.PrototypeGripperSubsystem;

public class ProtoGripperIntake extends BaseProtoGripperCommand {

	@Inject
	public ProtoGripperIntake(PrototypeGripperSubsystem gripper) {
		super(gripper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		gripper.normalIntake();
		
	}

}
