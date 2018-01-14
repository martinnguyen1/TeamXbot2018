package competition.subsystems.prototypeGripper;

import java.nio.file.ClosedWatchServiceException;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import xbot.common.command.BaseSubsystem;
import xbot.common.controls.actuators.XCANTalon;
import xbot.common.controls.actuators.XSolenoid;
import xbot.common.injection.wpi_factories.CommonLibFactory;
import xbot.common.properties.DoubleProperty;
import xbot.common.properties.XPropertyManager;

@Singleton
public class PrototypeGripperSubsystem extends BaseSubsystem {

	XCANTalon leftRoller;
	XCANTalon rightRoller;
	
	XSolenoid claw;
	
	boolean clawState = false;
	
	final DoubleProperty fastRollerSpeed;
	final DoubleProperty slowRollerSpeed;
	
	@Inject
	public PrototypeGripperSubsystem(XPropertyManager propMan, CommonLibFactory clf) {
		leftRoller = clf.createCANTalon(44);
		rightRoller = clf.createCANTalon(45);
		
		claw = clf.createSolenoid(6);
		
		fastRollerSpeed = propMan.createPersistentProperty("FastRollerSpeed", 0.8);
		slowRollerSpeed = propMan.createPersistentProperty("SlowRollerSpeed", 0.4);
	}
	
	public void toggleClaw() {
		clawState = !clawState;
		claw.setOn(clawState) ;
	}
	
	public void stopIntake() {
		leftRoller.set(ControlMode.PercentOutput, 0);
		rightRoller.set(ControlMode.PercentOutput, 0);
	}
	
	public void normalIntake() {
		leftRoller.simpleSet(fastRollerSpeed.get());
		rightRoller.simpleSet(fastRollerSpeed.get());
	}
	
	public void eject() {
		leftRoller.simpleSet(-fastRollerSpeed.get());
		rightRoller.simpleSet(-fastRollerSpeed.get());
	}
	
	public void leftIntake() {
		leftRoller.simpleSet(fastRollerSpeed.get());
		rightRoller.simpleSet(slowRollerSpeed.get());
	}
	
	public void rightIntake() {
		leftRoller.simpleSet(slowRollerSpeed.get());
		rightRoller.simpleSet(fastRollerSpeed.get());
	}
}
