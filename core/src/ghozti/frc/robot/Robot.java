package ghozti.frc.robot;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.frc.framework.frameworkutils.IO.ColorfulShell;
import ghozti.frc.framework.frameworkutils.commands.Command;
import ghozti.frc.robot.utils.Constants;

public class Robot {

    String directionFace;//using standard N,S,E,W
    double[] coodinates;//where index 0 is x and index 1 is y
    Rectangle hitbox;//basic rectangle to be used as a hitbox
    SpriteBatch batch;//sprite batch
    Texture robotTexture;//robot texture
    RobotContainer robotContainer = new RobotContainer();//new instance of robot container

    public Robot(SpriteBatch batch){
        this.batch = batch;
        robotTexture = new Texture("sol.png");
        directionFace = "W";
        coodinates = new double[]{0,0};
        hitbox = new Rectangle((float)coodinates[0], (float)coodinates[1], Constants.Robot.width, Constants.Robot.height);
        ColorfulShell.printCYAN("Robot initialized");
    }

    public void update(){
        robotContainer.configureBindings();
        coodinates[0] += robotContainer.drivetrain.getXControllerSpeed();
        coodinates[1] += robotContainer.drivetrain.getYControllerSpeed();
                
        hitbox.x = (float)coodinates[0];
        hitbox.y = (float)coodinates[1];
    }

    public void end(){

    }

    public void drawRobot(){
        batch.draw(robotTexture, (float)coodinates[0], (float)coodinates[1], Constants.Robot.width, Constants.Robot.height);
    }
}
