package org.firstinspires.ftc.teamcode.tdt.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.tdt.control_systems.Odometry.ThreeWheelTracker;
import org.firstinspires.ftc.teamcode.tdt.utils.robot_hardware.Motor;

import java.util.List;

public class UpdateOdometryCommand extends CommandBase {
    private final ThreeWheelTracker odometry;

    public UpdateOdometryCommand(ThreeWheelTracker odometry){
        this.odometry = odometry;
    }

    @Override
    public void execute() {
        this.odometry.updateTracker();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
