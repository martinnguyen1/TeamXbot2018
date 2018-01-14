package competition.subsystems.prototypeGripper.commands;

import com.google.inject.Inject;

import competition.subsystems.prototypeGripper.PrototypeGripperSubsystem;

public class BothEjectCommand extends BaseProtoGripperCommand {

	@Inject
	public BothEjectCommand(PrototypeGripperSubsystem gripper) {
		super(gripper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		gripper.eject();
	}

}
