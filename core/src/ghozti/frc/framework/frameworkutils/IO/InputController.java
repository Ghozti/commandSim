package ghozti.frc.framework.frameworkutils.IO;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputController {

    public static String getCurrentKey(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            return "W";
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            return "S";
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            return "D";
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            return "A";
        }
        return null;
    }
}
