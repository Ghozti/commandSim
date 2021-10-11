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

    public static String getDirection(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            return "N";
        }else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            return "S";
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            return "E";
        } else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            return "W";
        }
        return null;
    }

    /*
    **ISSUES:
    * the projectile follows the robot
    * the projectile only fires once and does not move on its own when shot
     */
}
