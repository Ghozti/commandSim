package ghozti.frc.game;

import com.badlogic.gdx.Screen;
import ghozti.frc.framework.frameworkutils.commands.SequentialCommandGroup;
import ghozti.frc.framework.frameworkutils.timer.Timer;
import ghozti.frc.framework.frameworkutils.timer.UniversalTimer;

public class GameLauncher implements Screen {
    @Override
    public void show() {

    }

    public void update(float delta){
        UniversalTimer.update(delta);
        if(SequentialCommandGroup.getCurrentIndex()+1 <= SequentialCommandGroup.getListSize()) {
            SequentialCommandGroup.executeCommands();
        }
    }

    @Override
    public void render(float delta) {
        update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
