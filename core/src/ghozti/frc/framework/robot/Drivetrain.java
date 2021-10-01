package ghozti.frc.framework.robot;

import  ghozti.frc.framework.frameworkutils.drives.Drive;
import ghozti.frc.framework.frameworkutils.hardware.Encoder;
import ghozti.frc.framework.frameworkutils.hardware.SpeedController;

public class Drivetrain {

    SpeedController leftController, rightController;
    Encoder leftEncoder, rightEncoder;
    Drive drive;


    public Drivetrain(){
        leftController = new SpeedController(0, true);
        rightController = new SpeedController(1, true);
        leftEncoder = new Encoder(leftController);
        rightEncoder = new Encoder(rightController);
        drive = new Drive(leftController,rightController);
    }

    public void updateBot(){
        leftEncoder.update();
        rightEncoder.update();
    }

    public void resetEncoders(){
        leftEncoder.reset();
        rightEncoder.reset();
    }

    public void killMotors(){
        rightController.kill();
        leftController.kill();
    }

    public double getLEftCount(){

    }

}
