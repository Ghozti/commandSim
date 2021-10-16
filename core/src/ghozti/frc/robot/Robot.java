package ghozti.frc.robot;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.frc.framework.frameworkutils.IO.ColorfulShell;
import ghozti.frc.framework.frameworkutils.IO.InputController;
import ghozti.frc.robot.utils.Constants;

import javax.swing.plaf.nimbus.AbstractRegionPainter;

public class Robot {

    String directionFace;//using standard N,S,E,W
    Rectangle hitbox;//basic rectangle to be used as a hitbox
    SpriteBatch batch;//sprite batch
    Texture robotTexture;//robot texture
    public RobotContainer robotContainer = new RobotContainer();//new instance of robot container

    public Robot(SpriteBatch batch){
        this.batch = batch;
        robotTexture = Constants.Robot.WEST;
        directionFace = "W";
        hitbox = new Rectangle(robotContainer.drivetrain.getX(), robotContainer.drivetrain.getY(), Constants.Robot.width, Constants.Robot.height);
        ColorfulShell.printCYAN("Robot initialized");
    }

    public void update(){
        robotContainer.configureBindings(directionFace);
        robotContainer.updateSystems();
        updateTexture();
                
        hitbox.x = robotContainer.drivetrain.getX();
        hitbox.y = robotContainer.drivetrain.getY();
    }

    public void drawRobot(){
        robotContainer.shooter.drawProjectile(batch);
        batch.draw(robotTexture, robotContainer.drivetrain.getX(), robotContainer.drivetrain.getY(), Constants.Robot.width, Constants.Robot.height);
    }

    public void updateTexture(){
        if (InputController.getDirection() == null){
            return;
        }else {
            switch (InputController.getDirection()) {
                case "N":
                    robotTexture = Constants.Robot.NORTH;
                    break;
                case "S":
                    robotTexture = Constants.Robot.SOUTH;
                    break;
                case "W":
                    robotTexture = Constants.Robot.WEST;
                    break;
                case "E":
                    robotTexture = Constants.Robot.EAST;
                    break;
            }
        }
    }
    //TODO comment
}
