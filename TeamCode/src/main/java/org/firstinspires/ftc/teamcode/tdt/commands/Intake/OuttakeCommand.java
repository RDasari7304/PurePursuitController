package org.firstinspires.ftc.teamcode.tdt.commands.Intake;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.tdt.subsystems.Intake;

public class OuttakeCommand extends CommandBase {
    private final Intake intake;

    public OuttakeCommand(Intake intake){
        this.intake = intake;
    }

    @Override
    public void initialize() {
        intake.unGrab();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
