package ghozti.frc.robot.commands;

import ghozti.frc.framework.frameworkutils.commands.Command;
import ghozti.frc.robot.subsystems.Drivetrain;

public class DriveDistance implements Command {

    private Drivetrain drivetrain;
    private double speedx, speedy, pixels;

    public DriveDistance(Drivetrain drivetrain, double speedx, double speedy, double pixels){
        this.drivetrain = drivetrain;
        this.speedx = speedx;
        this.speedy = speedy;
        this.pixels = pixels;
    }

    @Override
    public void init() {
        drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(speedx, speedy);
        drivetrain.updateBot();
    }

    @Override
    public void end() {
        drivetrain.killMotors();
        drivetrain.resetEncoders();
    }

    @Override
    public boolean isFinished() {
        if (speedx == 0){
            return drivetrain.getXEncoderDistance() >= pixels;
        }else if(speedy == 0){
            return drivetrain.getYEncoderDistance() >= pixels;
        }
        return (drivetrain.getYEncoderDistance() + drivetrain.getXEncoderDistance())/2 >= pixels;
    }
}
