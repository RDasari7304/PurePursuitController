package org.firstinspires.ftc.teamcode.tdt.opmodes.Tests;

import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.tdt.Robot;

public class OdometryTest extends CommandOpMode {
    private Robot robot;

    @Override
    public void initialize() {
        this.robot = new Robot(hardwareMap , telemetry);
    }

    @Override
    public void run() {
        super.run();
        telemetry.addData("x position : " , robot.driveTrain.odometry.getX());
        telemetry.addData("y position : " , robot.driveTrain.odometry.getY());
        telemetry.addData("heading : " , robot.driveTrain.odometry.getHeading());
        telemetry.update();
    }
}
