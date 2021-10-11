package ghozti.frc.robot;

import com.badlogic.gdx.graphics.g2d.Batch;
import ghozti.frc.framework.frameworkutils.IO.InputController;
import ghozti.frc.framework.frameworkutils.commands.Command;
import ghozti.frc.robot.commands.Autonomous;
import ghozti.frc.robot.subsystems.Drivetrain;
import ghozti.frc.robot.subsystems.Shooter;

public class RobotContainer {

    Drivetrain drivetrain = new Drivetrain();
    Shooter shooter = new Shooter(0,0);//TODO make drivetrain handle positioning
    boolean autonomousRunning = false;

    public void configureBindings(String direction){

        if (InputController.AutonomousReady() && !autonomousRunning){
            autonomousPeriodic();
            autonomousRunning = true;
        }

        if (InputController.shootShooter()){
            shooter.shoot(direction);
        }

        teleopDriveProcessor();
    }

    public void updateSystems(){
       drivetrain.updatePos();
       drivetrain.validatePosition();
       shooter.updateShooter(drivetrain.getX(),drivetrain.getY());
       shooter.updateProjectile(drivetrain.getX(),drivetrain.getY());
    }

    private void teleopDriveProcessor(){
        drivetrain.arcadeDrive(InputController.getCoordinateChanges()[0], InputController.getCoordinateChanges()[1]);
    }

    public Autonomous autonomousPeriodic(){
        return new Autonomous(drivetrain);
    }

    public void drawProjectile(Batch batch){
        shooter.drawProjectile(batch);
    }

}
