package ghozti.frc.robot;

import  ghozti.frc.framework.frameworkutils.drives.Drive;
import ghozti.frc.framework.frameworkutils.hardware.Encoder;
import ghozti.frc.framework.frameworkutils.hardware.SpeedController;

public class Drivetrain {

    SpeedController xController, yController;
    Encoder xEncoder, yEncoder;
    Drive drive;


    public Drivetrain(){
        xController = new SpeedController(0, true);
        yController = new SpeedController(1, true);
        xEncoder = new Encoder(xController);
        yEncoder = new Encoder(yController);
        drive = new Drive(xController,yController);
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

    public double getXEncoderDistance(){
        return xEncoder.getEncoderDistance();
    }

    public double getYEncoderDistance(){
        return yEncoder.getEncoderDistance();
    }

}
