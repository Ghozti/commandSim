package ghozti.frc.framework;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputController {

    public static String getCurrentKey(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            return "W";
        }

        return null;
    }
}
