package org.firstinspires.ftc.teamcode.tdt.commands.Spinner;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.tdt.subsystems.Spinner;

public class SpinnerRotateOutOnCommand extends CommandBase {
    private final Spinner spinner;

    public SpinnerRotateOutOnCommand(Spinner spinner){
        this.spinner = spinner;
    }

    @Override
    public void initialize() {
        spinner.rotateOut();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
