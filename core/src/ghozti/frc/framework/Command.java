package ghozti.frc.framework;

public interface Command {

    void init();

    void execute();

    void end();

    boolean isFinished();

}
