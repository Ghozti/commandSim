package ghozti.frc.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ghozti.frc.framework.frameworkutils.Field;
import ghozti.frc.framework.frameworkutils.commands.SequentialCommandGroup;
import ghozti.frc.framework.frameworkutils.timer.Timer;
import ghozti.frc.framework.frameworkutils.timer.UniversalTimer;
import ghozti.frc.robot.Robot;
import ghozti.frc.robot.utils.Constants;

public class GameLauncher implements Screen {

    SpriteBatch batch;
    Robot robot;
    Field field;

    public GameLauncher(){
        batch = new SpriteBatch();
        robot = new Robot(batch);
        field = new Field(batch);
    }

    @Override
    public void show() {

    }

    public void update(float delta){
        robot.update();
        UniversalTimer.update(delta);
        if(SequentialCommandGroup.getCurrentIndex()+1 <= SequentialCommandGroup.getListSize()) {
            SequentialCommandGroup.executeCommands();
        }
    }

    @Override
    public void render(float delta) {
        update(delta);
        batch.begin();
        field.draw();
        robot.robotContainer.drawProjectile(batch);
        robot.drawRobot();
        batch.end();
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
        batch.dispose();
    }
}
