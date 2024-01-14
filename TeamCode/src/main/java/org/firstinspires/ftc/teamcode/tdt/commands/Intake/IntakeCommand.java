package org.firstinspires.ftc.teamcode.tdt.commands.Intake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.tdt.control_systems.PointPursuit.PointPursuitPath;
import org.firstinspires.ftc.teamcode.tdt.control_systems.PointPursuit.PursuitMath;
import org.firstinspires.ftc.teamcode.tdt.subsystems.Intake;
import org.firstinspires.ftc.teamcode.tdt.subsystems.MecanumDriveTrain;
import org.firstinspires.ftc.teamcode.tdt.utils.Points.CurvePoint;

public class IntakeCommand extends CommandBase {
    private final Intake intake;

    public IntakeCommand(Intake intake){
        this.intake = intake;
    }

    @Override
    public void initialize() {
        intake.grab();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
