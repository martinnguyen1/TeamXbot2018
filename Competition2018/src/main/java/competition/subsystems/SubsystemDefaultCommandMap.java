package competition.subsystems;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import competition.subsystems.drive.DriveSubsystem;
import competition.subsystems.drive.commands.TankDriveWithJoysticksCommand;
import competition.subsystems.prototypeGripper.PrototypeGripperSubsystem;
import competition.subsystems.prototypeGripper.commands.StopGripperCommand;

@Singleton
public class SubsystemDefaultCommandMap {
    // For setting the default commands on subsystems

    @Inject
    public void setupDriveSubsystem(DriveSubsystem driveSubsystem, TankDriveWithJoysticksCommand command) {
        driveSubsystem.setDefaultCommand(command);
    }
    
    @Inject
    public void setupPrototypeClaw(PrototypeGripperSubsystem gripper, StopGripperCommand stop) {
    	gripper.setDefaultCommand(stop);
    }
}
