package org.firstinspires.ftc.teamcode.tdt;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.checkerframework.checker.units.qual.A;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.tdt.control_systems.PIDController.PIDConstants;
import org.firstinspires.ftc.teamcode.tdt.control_systems.PIDController.PIDTriplet;
import org.firstinspires.ftc.teamcode.tdt.subsystems.Arm;
import org.firstinspires.ftc.teamcode.tdt.subsystems.Intake;
import org.firstinspires.ftc.teamcode.tdt.subsystems.MecanumDriveTrain;
import org.firstinspires.ftc.teamcode.tdt.subsystems.Spinner;
import org.firstinspires.ftc.teamcode.tdt.utils.robot_hardware.Motor;

import java.util.ArrayList;

public class Robot implements ROBOT_CONSTANTS, PIDConstants {
    public MecanumDriveTrain driveTrain;
    public Spinner spinner;
    public Arm arm;
    public Intake intake;

    private final ArrayList<Motor> motorsUsingEncoders;


    public Robot(HardwareMap hwmap , Telemetry telemetry){
        driveTrain = new MecanumDriveTrain(tlName , blName , trName , brName , new PIDTriplet(DRIVE_KP , DRIVE_KI , DRIVE_KD) ,
                new PIDTriplet(STRAFE_KP , STRAFE_KI , STRAFE_KD) , new PIDTriplet(TURN_KP , TURN_KI , TURN_KD) , trackWidth , auxWidth , hwmap , telemetry);
       /* spinner = new Spinner(spinnerName , hwmap);
        arm = new Arm( armLName , armRName , new PIDTriplet(ARM_KP , ARM_KI , ARM_KD) , hwmap);
        intake = new Intake(intakeLName , intakeRName , hwmap);
*/
        driveTrain.setDtBreakMode();
        motorsUsingEncoders = new ArrayList<>();
        motorsUsingEncoders.add(driveTrain.odometry.LEncoder);
        motorsUsingEncoders.add(driveTrain.odometry.REncoder);
        motorsUsingEncoders.add(driveTrain.odometry.HEncoder);
    }


    public void resetAllMotors(){
        driveTrain.resetDtMotors();
        arm.resetMotors();/*
        spinner.reset();*/
    }

    public ArrayList<Motor> getMotorsUsingEncoders(){
        return this.motorsUsingEncoders;
    }


}