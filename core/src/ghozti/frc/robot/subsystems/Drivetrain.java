package ghozti.frc.robot.subsystems;

import com.badlogic.gdx.math.Rectangle;
import  ghozti.frc.framework.frameworkutils.drives.Drive;
import ghozti.frc.framework.frameworkutils.hardware.Encoder;
import ghozti.frc.framework.frameworkutils.hardware.SpeedController;

public class Drivetrain {

    SpeedController xController, yController;
    Encoder xEncoder, yEncoder;
    Drive drive;
    float[] coordinates;

    public Drivetrain(){
        xController = new SpeedController(0, true);
        yController = new SpeedController(1, true);
        xEncoder = new Encoder(xController);
        yEncoder = new Encoder(yController);
        drive = new Drive(xController,yController);
        coordinates = new float[2];
    }

    public void updateBot(){
        xEncoder.update();
        yEncoder.update();
    }

    public void arcadeDrive(double speedx, double speedy){
        drive.arcadeDrive(speedx,speedy);
    }

    public void resetEncoders(){
        xEncoder.reset();
        yEncoder.reset();
    }

    public void killMotors(){
        xController.kill();
        yController.kill();
    }

    public double getXControllerSpeed(){
        return xController.getSpeed();
    }

    public double getYControllerSpeed(){
        return yController.getSpeed();
    }

    public double getXEncoderDistance(){
        return xEncoder.getEncoderDistance();
    }

    public double getYEncoderDistance(){
        return yEncoder.getEncoderDistance();
    }

    public void updatePos(){
        coordinates[0] += getXControllerSpeed();
        coordinates[1] += getYControllerSpeed();
    }

    public float getX(){return coordinates[0];}

    public float getY(){return coordinates[1];}

    public void validatePosition(){
        if (coordinates[0] < 0){
            coordinates[0] = 0;
        }else if(coordinates[0] > 1180){
            coordinates[0] = 1180;
        }
        if (coordinates[1] < 0){
            coordinates[1] = 0;
        }else if(coordinates[1] > 620){
            coordinates[1] = 620;
        }
    }
}
