package ghozti.frc.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ghozti.frc.game.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Game(), config);

		config.title = "frc robot sim";
		config.width = 1280;
		config.height = 720;
		config.foregroundFPS = 120;
		config.backgroundFPS = 30;
	}
}
