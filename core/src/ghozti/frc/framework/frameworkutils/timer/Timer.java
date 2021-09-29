package ghozti.frc.framework.frameworkutils.timer;

public class Timer {

    double elapsedTime, endTime;
    boolean timed;

    public Timer(){
        timed = false;
    }

    public Timer(double endTime){
        timed = true;
        this.endTime = endTime;
    }

    public void startTimer(double delta){
        elapsedTime += delta;
    }

    public boolean isFinished(){
        return elapsedTime >= endTime;
    }

    public double getElapsedTime(){
        return elapsedTime;
    }

    public double getABStime(){
        return Math.abs(elapsedTime);
    }
}
