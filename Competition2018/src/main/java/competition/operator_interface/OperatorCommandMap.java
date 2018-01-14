package competition.operator_interface;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import competition.subsystems.prototypeGripper.commands.BothEjectCommand;
import competition.subsystems.prototypeGripper.commands.LeftIntakeCommand;
import competition.subsystems.prototypeGripper.commands.ProtoGripperIntake;
import competition.subsystems.prototypeGripper.commands.RightIntake;
import competition.subsystems.prototypeGripper.commands.ToggleClawCommand;
import competition.subsystems.prototypeshifter.ToggleShiftCommand;

@Singleton
public class OperatorCommandMap {
    // For mapping operator interface buttons to commands

    // Example for setting up a command to fire when a button is pressed:
    /*
    @Inject
    public void setupMyCommands(
            OperatorInterface operatorInterface,
            MyCommand myCommand)
    {
        operatorInterface.leftButtons.getifAvailable(1).whenPressed(myCommand);
    }
    */
	
	@Inject
    public void setupPrototype(
    		OperatorInterface oi,
    		LeftIntakeCommand intakeLeft,
    		RightIntake intakeRight,
    		ProtoGripperIntake intakeBoth,
    		ToggleClawCommand claw,
    		ToggleShiftCommand shift,
    		BothEjectCommand eject) {
    	
		oi.gamepad.getifAvailable(1).whileHeld(intakeLeft);
		oi.gamepad.getifAvailable(2).whileHeld(intakeRight);
		oi.gamepad.getifAvailable(3).whenPressed(shift);
		
		oi.gamepad.getifAvailable(4).whenPressed(claw);
		oi.gamepad.getifAvailable(5).whileHeld(intakeBoth);
		oi.gamepad.getifAvailable(6).whileHeld(eject);
	}
    	
}
