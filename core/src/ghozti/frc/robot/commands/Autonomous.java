package ghozti.frc.robot.commands;

import ghozti.frc.framework.frameworkutils.commands.SequentialCommandGroup;
import ghozti.frc.robot.subsystems.Drivetrain;

public class Autonomous extends SequentialCommandGroup {

    public Autonomous(Drivetrain train){
        addCommands(new DriveDistance(train, 10,0, 1000), new DriveDistance(train, -10,0,1000), new DriveDistance(train, 0,10,1000));
    }
}
