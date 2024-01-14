package org.firstinspires.ftc.teamcode.tdt.opmodes.Tests;

import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.tdt.Robot;

public class EncodersReverseTest extends CommandOpMode {
    private Robot robot;

    @Override
    public void initialize() {
        this.robot = new Robot(hardwareMap , telemetry);
    }


    @Override
    public void run() {
        super.run();

        telemetry.addData("left inches : " , robot.driveTrain.getLEncoderInches());
        telemetry.addData("Right inches : " , robot.driveTrain.getREncoderInches());
        telemetry.addData("Horizontal inches : " , robot.driveTrain.getHEncoderInches());
        telemetry.update();
    }
}
