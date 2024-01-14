package org.firstinspires.ftc.teamcode.tdt.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.tdt.utils.robot_hardware.Motor;


public class Spinner extends SubsystemBase {
    private final Motor spinnerMotor;

    private final double movePower = 0.7;

    public Spinner(Motor motor){
        this.spinnerMotor = motor;
    }

    public void rotate(){
        spinnerMotor.setPower(movePower);
    }

    public void rotateOut(){
        spinnerMotor.setPower(-movePower);
    }

    public void stop(){
        spinnerMotor.setPower(0);
    }

}
