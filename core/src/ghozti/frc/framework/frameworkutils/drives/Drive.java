package ghozti.frc.framework.frameworkutils.drives;

import ghozti.frc.framework.frameworkutils.hardware.SpeedController;

public class Drive {

    SpeedController speedController1, speedController2;

    public Drive(SpeedController speedController1, SpeedController speedController2){
        this.speedController1 = speedController1;
        this.speedController2 = speedController2;
    }

    public void arcadeDrive(double speed1, double speed2){
        setLeftSpeed(speed1);
        setRightSpeed(speed2);
    }

    private void setLeftSpeed(double speed){
        speedController1.setSpeed(speed);
    }

    private void setRightSpeed(double speed){
        speedController2.setSpeed(speed);
    }
}