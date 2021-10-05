package ghozti.frc.robot.commands;

import ghozti.frc.framework.frameworkutils.commands.Command;
import ghozti.frc.robot.subsystems.Drivetrain;

public class DriveDegrees implements Command {

    double speed, degrees;
    Drivetrain drivetrain;

    public DriveDegrees(Drivetrain drivetrain, double speed, double degrees){
        this.drivetrain = drivetrain;
        this.speed = speed;
        this.degrees = degrees;
    }

    @Override
    public void init() {
        drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(speed,speed);
    }

    @Override
    public void end() {
        drivetrain.killMotors();
        drivetrain.resetEncoders();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
