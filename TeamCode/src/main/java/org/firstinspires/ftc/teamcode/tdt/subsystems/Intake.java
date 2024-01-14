package org.firstinspires.ftc.teamcode.tdt.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.tdt.utils.robot_hardware.TDTCRServo;

public class Intake extends SubsystemBase {
    public Servo clawLeft;
    public Servo clawRight;

    public final double intakeLeftPosition = -0.75;
    public final double intakeRightPosition = 0.75;

    public final double outtakeLeftPosition = 0;
    public final double outtakeRightPosition = 0;


    public Intake(Servo clawLeft , Servo clawRight){
        this.clawLeft = clawLeft;
        this.clawRight = clawRight;
    }

    public void grab(){
        clawLeft.setPosition(intakeLeftPosition);
        clawRight.setPosition(intakeRightPosition);
    }

    public void unGrab(){
        clawLeft.setPosition(outtakeLeftPosition);
        clawRight.setPosition(outtakeRightPosition);
    }

}
