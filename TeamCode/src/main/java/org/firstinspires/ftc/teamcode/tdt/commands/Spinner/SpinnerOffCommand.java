package org.firstinspires.ftc.teamcode.tdt.commands.Spinner;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.tdt.subsystems.Spinner;

public class SpinnerOffCommand extends CommandBase {
    private final Spinner spinner;

    public SpinnerOffCommand(Spinner spinner){
        this.spinner = spinner;
    }

    @Override
    public void initialize() {
        spinner.rotate();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
