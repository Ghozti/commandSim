package ghozti.frc.robot.utils;

import com.badlogic.gdx.graphics.Texture;
import org.w3c.dom.Text;

public class Constants {

    public static class Game{
        public static final float width = 1280;// screen width
        public static final float height = 720;//screen height
    }

    public static class Robot {
        public static final double maxRobotSpeed = 15;// in pixels pixels
        public static final double acceleration = 5;//in pixels
        public static final float width = 50;
        public static final float height = 50;
    }

    public static class Field{
        public static final Texture fieldTexture = new Texture("infinite-recharge.jpg");//TODO fill this
        public static final float width = 1280;//field width
        public static final float height = 720;//field height
    }
}
