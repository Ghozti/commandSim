package ghozti.frc.robot.commands;

import ghozti.frc.framework.frameworkutils.commands.Command;
import ghozti.frc.robot.subsystems.Drivetrain;

public class Teleop implements Command {

    private double supplierx, suppliery;
    private Drivetrain drivetrain;

    public Teleop(Drivetrain train, double supplierx, double suppliery){
        this.drivetrain = train;
        this.supplierx = supplierx;
        this.suppliery  = suppliery;
    }

    @Override
    public void init() {
        System.out.println("Teleop initialized...");
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(supplierx,suppliery);
    }

    @Override
    public void end() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
