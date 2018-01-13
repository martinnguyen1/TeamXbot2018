package competition.subsystems.lean.commands;

import com.google.inject.Inject;

import competition.subsystems.lean.LeanSubsystem;
import xbot.common.command.BaseCommand;

public class LeanLeftCommand extends BaseCommand {

	LeanSubsystem leaner;
	boolean stop;
	
	@Inject
	public LeanLeftCommand(LeanSubsystem leaner) {
		this.leaner = leaner;
	}
	
	@Override
	public void initialize() {
		log.info("Initializing");
	}

	@Override
	public void execute() {
		leaner.leanLeft();
		if (leaner.HitBar()) {
			stop = true;
			leaner.stopLean();
		}
		else {
			stop = false;
		}
	}
	@Override
	public boolean isFinished() {
		if (stop) {
			return true;
		}
		else {
			return false;
		}
	}

}

