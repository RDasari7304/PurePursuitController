package org.firstinspires.ftc.teamcode.tdt.opmodes.Tests;


import android.graphics.Point;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;

import org.firstinspires.ftc.teamcode.tdt.Robot;
import org.firstinspires.ftc.teamcode.tdt.commands.Autonomous.Pathing.PathFollowingCommands.FollowPathCommand;
import org.firstinspires.ftc.teamcode.tdt.commands.Autonomous.Pathing.PathFollowingCommands.PathMarkerCommand;
import org.firstinspires.ftc.teamcode.tdt.commands.UpdateOdometryCommand;
import org.firstinspires.ftc.teamcode.tdt.commands.Intake.IntakeCommand;
import org.firstinspires.ftc.teamcode.tdt.commands.Intake.OuttakeCommand;
import org.firstinspires.ftc.teamcode.tdt.commands.LynxCacheCommand;
import org.firstinspires.ftc.teamcode.tdt.control_systems.PointPursuit.PointPursuitPath;
import org.firstinspires.ftc.teamcode.tdt.utils.Points.CurvePoint;

public class MarkerTest extends CommandOpMode {
    private Robot robot;
    private PointPursuitPath intakePath;

    @Override
    public void initialize() {
        this.robot = new Robot(hardwareMap , telemetry);
        intakePath = new PointPursuitPath();
        intakePath.add(new CurvePoint(new Point(0 , 0), 0.75 , 90 , 0 , 0));
        intakePath.add(new CurvePoint(new Point(0 , 20), 0.75 , 90 , 0 , 0));
        intakePath.add(new CurvePoint(new Point(20 , 20), 0.75 , 90 , 500 , 2));
        intakePath.addProgressMarker(0.5 , new IntakeCommand(robot.intake));
        intakePath.addProgressMarker(0.75 , new OuttakeCommand(robot.intake));

    }

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        CommandScheduler.getInstance().schedule(
                new LynxCacheCommand(hardwareMap)
                .andThen(new UpdateOdometryCommand(robot.driveTrain.odometry))
        );

        CommandScheduler.getInstance().schedule(
                new PathMarkerCommand(intakePath , robot.driveTrain)
                .deadlineWith(new FollowPathCommand(robot.driveTrain , intakePath))
        );

    }



}
