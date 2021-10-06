package ghozti.frc.robot;

import ghozti.frc.framework.frameworkutils.IO.InputController;
import ghozti.frc.framework.frameworkutils.commands.Command;
import ghozti.frc.robot.commands.Autonomous;
import ghozti.frc.robot.subsystems.Drivetrain;

public class RobotContainer {

    Drivetrain drivetrain = new Drivetrain();
    boolean autonomousRunning = false;

    public void configureBindings(){

        if (InputController.AutonomousReady() && !autonomousRunning){
            autonomousPeriodic();
            autonomousRunning = true;
        }

        teleopDriveProcessor();
    }

    private void teleopDriveProcessor(){
        drivetrain.arcadeDrive(InputController.getCoordinateChanges()[0], InputController.getCoordinateChanges()[1]);
    }

    public Autonomous autonomousPeriodic(){
        return new Autonomous(drivetrain);
    }

}
