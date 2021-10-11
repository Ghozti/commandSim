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
    double[] coodinates;//where index 0 is x and index 1 is y
    Rectangle hitbox;//basic rectangle to be used as a hitbox
    SpriteBatch batch;//sprite batch
    Texture robotTexture;//robot texture
    public RobotContainer robotContainer = new RobotContainer();//new instance of robot container

    public Robot(SpriteBatch batch){
        this.batch = batch;
        robotTexture = Constants.Robot.WEST;
        directionFace = "W";
        coodinates = new double[]{0,0};
        hitbox = new Rectangle((float)coodinates[0], (float)coodinates[1], Constants.Robot.width, Constants.Robot.height);
        ColorfulShell.printCYAN("Robot initialized");
    }

    public void update(){
        robotContainer.configureBindings();
        coodinates[0] += robotContainer.drivetrain.getXControllerSpeed();
        coodinates[1] += robotContainer.drivetrain.getYControllerSpeed();
        validatePosition();
        updateTexture();
                
        hitbox.x = (float)coodinates[0];
        hitbox.y = (float)coodinates[1];
    }

    public void drawRobot(){
        batch.draw(robotTexture, (float)coodinates[0], (float)coodinates[1], Constants.Robot.width, Constants.Robot.height);
    }

    private void validatePosition(){
        if (coodinates[0] < 0){
            coodinates[0] = 0;
        }else if(coodinates[0] > 1180){
            coodinates[0] = 1180;
        }
        if (coodinates[1] < 0){
            coodinates[1] = 0;
        }else if(coodinates[1] > 620){
            coodinates[1] = 620;
        }
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
}
