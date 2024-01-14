package org.firstinspires.ftc.teamcode.tdt.opmodes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.tdt.Robot;

public class TeleOp extends CommandOpMode {
    private Robot robot;
    private GamepadEx D1;
    private GamepadEx D2;

    @Override
    public void initialize() {
        robot = new Robot(hardwareMap , telemetry);
        robot.resetAllMotors();
        D1 = new GamepadEx(gamepad1);
        D2 = new GamepadEx(gamepad2);
    }

    @Override
    public void run() {
        super.run();

        robot.driveTrain.robotCentric(D1.getLeftX() , -D1.getLeftY() , D1.getRightX());
        D2.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).whenPressed(robot.intake::unGrab);
        D2.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(robot.intake::grab);

        if(D2.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) > 0.1){
            robot.spinner.rotate();
        }else if(D2.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.1){
            robot.spinner.rotateOut();
        }else{
            robot.spinner.stop();
        }


    }
}
