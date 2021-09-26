package ghozti.frc;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends com.badlogic.gdx.Game {

	@Override
	public void create() {
		setScreen(new GameLauncher());
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
		screen.dispose();
	}

	@Override
	public void resize(int width, int height) {
		screen.resize(width, height);
	}
}
