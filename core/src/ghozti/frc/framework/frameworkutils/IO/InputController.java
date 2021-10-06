package ghozti.frc.framework.frameworkutils.IO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputController {

    public static double[] getCoordinateChanges(){

        double xAxisChange = 0, yAxisChange = 0;

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            yAxisChange = 10;
        }else if(Gdx.input.isKeyPressed(Input.Keys.S)){
            yAxisChange = -10;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            xAxisChange = 10;
        } else if(Gdx.input.isKeyPressed(Input.Keys.A)){
            xAxisChange = -10;
        }
        return new double[]{xAxisChange,yAxisChange};
    }

    public static boolean AutonomousReady(){
        return Gdx.input.isKeyPressed(Input.Keys.E);
    }
}
