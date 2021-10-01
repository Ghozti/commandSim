package ghozti.frc.framework.frameworkutils.hardware;

import ghozti.frc.framework.frameworkutils.timer.Timer;
import ghozti.frc.framework.frameworkutils.timer.UniversalTimer;

public class Encoder {

    SpeedController speedController;
    protected double distanceCovered;
    private double seconds;

    public Encoder(SpeedController speedController){
        this.speedController = speedController;
    }

    public void update(){
        if (speedController.speed > 0){
            seconds += UniversalTimer.getElapsedTime();
            if (seconds >= 1){
                distanceCovered += (speedController.speed * seconds) + (.5 * (speedController.speed * (2)));
            }
            seconds = 0;
        }
    }

    public double getEncoderDistance(){
        return distanceCovered;
    }

    public void reset(){
        distanceCovered = 0;
    }
}
