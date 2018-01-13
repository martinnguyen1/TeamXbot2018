package competition.subsystems.prototypeGripper.commands;

import com.google.inject.Inject;

import competition.subsystems.prototypeGripper.PrototypeGripperSubsystem;
import xbot.common.command.BaseCommand;

public abstract class BaseProtoGripperCommand extends BaseCommand {

	protected PrototypeGripperSubsystem gripper;
	
	@Inject
	public BaseProtoGripperCommand(PrototypeGripperSubsystem gripper) {
		this.gripper = gripper;
		this.requires(gripper);
	}	
}
