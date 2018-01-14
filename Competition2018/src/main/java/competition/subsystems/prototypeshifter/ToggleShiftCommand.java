package competition.subsystems.prototypeshifter;

import com.google.inject.Inject;

import xbot.common.command.BaseCommand;

public class ToggleShiftCommand extends BaseCommand {

	PrototypeShifter shifter;
	
	@Inject
	public ToggleShiftCommand(PrototypeShifter shifter) {
		// TODO Auto-generated constructor stub
		this.shifter = shifter;
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		shifter.toggleShift();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
