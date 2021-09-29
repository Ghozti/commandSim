package ghozti.frc.framework.robot.commands;

import ghozti.frc.framework.frameworkutils.commands.Command;

public class Teleop implements Command {

    @Override
    public void init() {
        System.out.println("Teleop initialized...");
    }

    @Override
    public void execute() {

    }

    @Override
    public void end() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
