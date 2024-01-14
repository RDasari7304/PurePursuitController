package org.firstinspires.ftc.teamcode.tdt.control_systems.Odometry;

import org.firstinspires.ftc.teamcode.RobotHardware.Motor;

public class TankOdometry {
    private Motor leftEncoder;
    private Motor rightEncoder;
    private double prevLeftPos = 0;
    private double prevRightPos = 0;
    private double heading = 0;
    private double x = 0;
    private double y = 0;
    private double trackWidth = 0;

    public TankOdometry(double trackWidth){
        this.trackWidth = trackWidth;
    }

    public void update(){
        double currLeft = leftEncoder.getCurrPosInches();
        double currRight = rightEncoder.getCurrPosInches();

        double leftChange = (currLeft - prevLeftPos);
        prevLeftPos = currLeft;
        double rightChange = (currRight - prevRightPos);
        prevRightPos = currRight;

        double theta = (leftChange - rightChange) / trackWidth;
        double relativeY = (leftChange + rightChange) / 2.0;


        double currX = (relativeY * Math.sin(theta));
        double currY = (relativeY * Math.cos(theta));


        x += currX;
        y += currY;
        heading = theta;

    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getHeading(){
        return heading;
    }




}
