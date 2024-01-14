package org.firstinspires.ftc.teamcode.tdt.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.tdt.control_systems.Odometry.ThreeWheelTracker;
import org.firstinspires.ftc.teamcode.tdt.control_systems.PIDController.PIDTriplet;
import org.firstinspires.ftc.teamcode.tdt.control_systems.PointPursuit.PointPursuitPath;
import org.firstinspires.ftc.teamcode.tdt.subsystems.DriveTrain;
import org.firstinspires.ftc.teamcode.tdt.utils.time.TDTTimer;

import java.util.Arrays;
import java.util.List;

public class MecanumDriveTrain extends DriveTrain {
    private Telemetry telemetry;

    private final TDTTimer timer;
    private final boolean resetTimer = false;

    public ThreeWheelTracker odometry;

    public MecanumDriveTrain(String tlName, String blName, String trName, String brName, PIDTriplet DrivePID , PIDTriplet StrafePID , PIDTriplet turnPID , double trackWidth , double auxWidth , HardwareMap hardwareMap , Telemetry telemetry) {
        super(tlName, blName, trName, brName, DrivePID , StrafePID , turnPID ,  hardwareMap);
        odometry = new ThreeWheelTracker(brName , blName , tlName , trackWidth , auxWidth , hardwareMap , telemetry);

        timer = new TDTTimer();
        this.telemetry = telemetry;
    }

    public void fieldCentric(double xSpeed, double ySpeed, double turn , double movementSpeed){
        double angle = Math.atan2(ySpeed , xSpeed) - Math.toRadians(odometry.getHeading());

        double speed = Math.hypot(ySpeed , xSpeed);

        double move_x = speed * Math.cos(angle);
        double move_y = speed * Math.sin(angle);

        move_x = Range.clip(move_x , -movementSpeed , movementSpeed);
        move_y = Range.clip(move_y , -movementSpeed , movementSpeed);

        robotCentric(move_x , move_y , turn);
    }


    public void robotCentric(double x , double y , double turn){
        double tlPower = (y ) + (x )  - (turn );
        double blPower = (y) - (x)  - (turn );
        double trPower = (y ) - (x)  + (turn );
        double brPower = (y ) + (x)  + (turn );

        List<Double> powerList = Arrays.asList(tlPower, blPower, trPower, brPower);
        normalizeMecanumPowers(powerList);

        tl.setPower(powerList.get(0));
        bl.setPower(powerList.get(1));
        tr.setPower(powerList.get(2));
        br.setPower(powerList.get(3));
    }


    public void resetDtMotors(){
        tl.resetMotor();
        tr.resetMotor();
        bl.resetMotor();
        br.resetMotor();
    }


    public void normalizeMecanumPowers(List<Double> powerList){
        double max = 0;

        for(double d : powerList){
            if(Math.abs(d) > max){
                max = Math.abs(d);
            }
        }

        if (max > 1) {
            for (int i = 0; i < powerList.size(); i++) {
                double current = powerList.get(i);
                powerList.set(i, current / max);
            }
        }
    }

    public void setTelemetry(Telemetry telemetry){
        this.telemetry = telemetry;
    }

    public double getLEncoderInches(){
        return this.odometry.getLeftInches();
    }

    public double getREncoderInches(){
        return this.odometry.getRightInches();
    }

    public double getHEncoderInches(){
        return this.odometry.getHorizontalInches();
    }

}
