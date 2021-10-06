package ghozti.frc.robot;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ghozti.frc.framework.frameworkutils.IO.ColorfulShell;
import org.w3c.dom.Text;

public class Robot {

    SpriteBatch batch;
    Texture robotTexture;
    RobotContainer robotContainer = new RobotContainer();

    public Robot(SpriteBatch batch){
        this.batch = batch;
        ColorfulShell.printCYAN("Robot initialized");
    }

    public void update(){
        robotContainer.configureBindings();
    }

    public void end(){

    }

    public void drawRobot(){
        //batch.draw();
    }
}
