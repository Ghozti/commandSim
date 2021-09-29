package ghozti.frc.framework.frameworkutils.commands;

public interface Command {

    void init();

    void execute();

    void end();

    boolean isFinished();

}
