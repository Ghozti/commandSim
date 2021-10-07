package ghozti.frc.framework.frameworkutils.hardware;

public class SpeedController {

    double port, speed;
    boolean brushless;

    public SpeedController(double port, boolean brushless){
        this.port = port;
        this.brushless = brushless;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void kill(){
        this.speed = 0;
    }

    public void setInverted(boolean inverted){
        if (inverted) speed = -speed;
    }

    public double getSpeed(){
        return speed;
    }
}
