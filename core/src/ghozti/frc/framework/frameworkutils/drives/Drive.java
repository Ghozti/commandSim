package ghozti.frc.framework.frameworkutils.drives;

import ghozti.frc.framework.frameworkutils.hardware.SpeedController;

public class Drive {

    SpeedController xController, yController;

    public Drive(SpeedController xController, SpeedController yController){
        this.xController = xController;
        this.yController = yController;
    }

    public void arcadeDrive(double speedx, double speedy){
        setXSpeed(speedx);
        setYSpeed(speedy);
    }

    private void setXSpeed(double speed){
        xController.setSpeed(speed);
    }

    private void setYSpeed(double speed){
        yController.setSpeed(speed);
    }
}
