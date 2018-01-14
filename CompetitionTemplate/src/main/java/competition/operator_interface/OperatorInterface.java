package competition.operator_interface;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import competition.subsystems.prototypeGripper.commands.LeftIntakeCommand;
import competition.subsystems.prototypeGripper.commands.ProtoGripperIntake;
import competition.subsystems.prototypeGripper.commands.RightIntake;
import competition.subsystems.prototypeGripper.commands.ToggleClawCommand;
import xbot.common.controls.sensors.XFTCGamepad;
import xbot.common.controls.sensors.XJoystick;
import xbot.common.controls.sensors.wpi_adapters.FTCGamepadWpiAdapter;
import xbot.common.injection.wpi_factories.CommonLibFactory;
import xbot.common.logging.RobotAssertionManager;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups
 * that allow control of the robot.
 */
@Singleton
public class OperatorInterface {
    public XJoystick leftJoystick;
    public XJoystick rightJoystick;
    public XFTCGamepad gamepad;

    @Inject
    public OperatorInterface(CommonLibFactory factory, RobotAssertionManager assertionManager) {
        leftJoystick = factory.createJoystick(1, 10);
        rightJoystick = factory.createJoystick(2, 10);
        gamepad = factory.createGamepad(3, 10);
        
        gamepad.setLeftStickYInversion(true);
        gamepad.setRightStickYInversion(true);
        
        leftJoystick.setYInversion(true);
        rightJoystick.setXInversion(true);
        
    }
}
