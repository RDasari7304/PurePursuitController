package org.firstinspires.ftc.teamcode.tdt.opmodes.Tests;

import com.arcrobotics.ftclib.command.CommandOpMode;

import org.firstinspires.ftc.teamcode.tdt.Robot;
import org.firstinspires.ftc.teamcode.tdt.commands.Autonomous.Pathing.PathFollowingCommands.GoToXYHCommand;

public class PIDTuner extends CommandOpMode {
    public static double DRIVE_KP = 0;
    public static double DRIVE_KI = 0;
    public static double DRIVE_KD = 0;

    public static double STRAFE_KP = 0;
    public static double STRAFE_KI = 0;
    public static double STRAFE_KD = 0;

    public static double TURN_KP = 0;
    public static double TURN_KI = 0;
    public static double TURN_KD = 0;

    private Robot robot;

    @Override
    public void initialize() {
        this.robot = new Robot(hardwareMap , telemetry);
        this.robot.driveTrain.driveController.setConstants(DRIVE_KP , DRIVE_KI , DRIVE_KD);
        this.robot.driveTrain.strafeController.setConstants(STRAFE_KP , STRAFE_KI , STRAFE_KD);
        this.robot.driveTrain.turnController.setConstants(TURN_KP , TURN_KI , TURN_KD);
    }

    @Override
    public void run() {
        super.run();
        new GoToXYHCommand(0 , 10 , 0 , 0.75 , 500 , 2).schedule();
    }
}
