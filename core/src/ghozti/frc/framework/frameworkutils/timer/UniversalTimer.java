package ghozti.frc.framework.frameworkutils.timer;

public class UniversalTimer {

    private static double deltaTime;

    public static void update(float delta){deltaTime += delta;}

    public static double getElapsedTime(){return deltaTime;}

}
