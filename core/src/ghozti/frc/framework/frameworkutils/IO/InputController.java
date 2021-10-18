package ghozti.frc.framework.frameworkutils.IO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import ghozti.frc.robot.utils.Constants;

public class InputController {

    public static double[] getCoordinateChanges(){

        double xAxisChange = 0, yAxisChange = 0;

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            yAxisChange = Constants.Robot.maxRobotSpeed;
        }else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            yAxisChange = -Constants.Robot.maxRobotSpeed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            xAxisChange = Constants.Robot.maxRobotSpeed;
        } else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            xAxisChange = -Constants.Robot.maxRobotSpeed;
        }
        return new double[]{xAxisChange,yAxisChange};
    }

    public static boolean AutonomousReady(){
        return Gdx.input.isKeyPressed(Input.Keys.E);
    }

    public static boolean shootShooter(){return Gdx.input.isKeyPressed(Input.Keys.SPACE);}

    static String storedDir;

    public static String getDirection(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            storedDir = "N";
            return "N";
        }else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            storedDir = "S";
            return "S";
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            storedDir = "E";
            return "E";
        } else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            storedDir = "W";
            return "W";
        }
        return storedDir;
    }
}
