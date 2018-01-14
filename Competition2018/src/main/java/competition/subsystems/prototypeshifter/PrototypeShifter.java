package competition.subsystems.prototypeshifter;

import com.google.inject.Inject;

import xbot.common.command.BaseSubsystem;
import xbot.common.controls.actuators.XSolenoid;
import xbot.common.injection.wpi_factories.CommonLibFactory;

public class PrototypeShifter extends BaseSubsystem {

	XSolenoid shifter;
	boolean shiftState = false;
	
	@Inject
	public PrototypeShifter(CommonLibFactory clf) {
		shifter = clf.createSolenoid(1);
	}
	
	public void toggleShift() {
		shiftState = !shiftState;
		shifter.setOn(shiftState);
	}
}
