package org.firstinspires.ftc.teamcode.tdt.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.tdt.control_systems.PIDController.PIDController;
import org.firstinspires.ftc.teamcode.tdt.control_systems.PIDController.PIDTriplet;
import org.firstinspires.ftc.teamcode.tdt.utils.robot_hardware.Motor;
import org.firstinspires.ftc.teamcode.tdt.utils.time.TDTTimer;


public class Arm {
    public Motor armLMotor;
    public Motor armRMotor;

    private final double movePower = 0.3;

    private final double targetPosition = 0;

    private final double KP = 0;
    private final double KI = 0;
    private final double KD = 0;

    public PIDController extendController;

    private final double lowLevelPosition = 1000;
    private final double middleLevelPosition = 510;
    private final double highLevelPosition = 250;
    private final double startingPosition = 0;

    private final boolean resetTimer = false;
    private final TDTTimer timer = new TDTTimer();

    public enum extendPositions{
        LOW ,
        MIDDLE ,
        HIGH ,
        STARTING
    }


    public Arm(String motorLName , String motorRName , PIDTriplet extendConstants , HardwareMap hwmap){
        armLMotor = new Motor(motorLName , hwmap);
        armRMotor = new Motor(motorRName , hwmap);

        armRMotor.setBreakMode();
        armLMotor.setBreakMode();

        /*extendController = new PIDController(extendConstants.getKP() , extendConstants.getKI() , extendConstants.getKD());
    */}

    public void driverControl(Gamepad gamepad){
        /*

        if(gamepad.left_bumper) targetPosition = 1000;
        else if(gamepad.right_bumper) targetPosition = 0;

        */
        armLMotor.setPower(-gamepad.left_stick_y);
        armRMotor.setPower(-gamepad.left_stick_y);
        /*
        if(-gamepad.right_stick_y > 0.1) extend();
        else if(-gamepad.right_stick_y < 0.1) retract();
        else stop();*/


/*

        double power = extendController.getOutput(armRMotor.getCurrentPosition() , targetPosition);

        armLMotor.setPower(power);
        armRMotor.setPower(power);
*/

    }

/*
    public void unHook(){
        shippingServo.setPosition(-1.0 );
    }

    public void hook(){
        shippingServo.setPosition(0.5);
    }*/

    public void extend(){

        armRMotor.setPower(movePower);
        armLMotor.setPower(movePower);
    }




    public boolean extendToLevel(extendPositions extendPosition , double stopTime){
/*
        if(!resetTimer){
            timer.reset();
            timer.beginStartTime();
            resetTimer = true;
        }

        boolean isUnderStopState = timer.isUnderStopState(stopTime);


        switch (extendPosition) {
            case LOW:
                targetPosition = lowLevelPosition;
                break;
            case MIDDLE:
                targetPosition = middleLevelPosition;
                break;
            case HIGH:
                targetPosition = highLevelPosition;
                break;
            case STARTING:
                targetPosition = startingPosition;
                break;
        }


        if(isUnderStopState) {

            double power = extendController.getOutput(armRMotor.getCurrentPosition(), targetPosition);
            armRMotor.setPower(power);
            armLMotor.setPower(power);

            if (Math.abs(extendController.getError()) <= 15) {
                timer.beginStopState();
            } else {
                timer.beginStartTime();
            }

            return false;

        }else{
            stop();
            resetTimer = false;
            return true;

        }*/
        return true;
    }

    public boolean isErrorLowerThan(double error){
        return extendController.getError() < error;
    }

    public void retract(){
        armLMotor.setPower(-movePower);
        armRMotor.setPower(-movePower);
    }

    public void stop(){
        armLMotor.setPower(0);
        armRMotor.setPower(0);
    }

    public void setBreakMode(){
        armLMotor.setBreakMode();
        armRMotor.setBreakMode();
    }

    public void resetMotors(){
        armLMotor.resetMotor();
        armRMotor.resetMotor();
    }

}
