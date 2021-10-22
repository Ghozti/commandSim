package ghozti.frc.framework.frameworkutils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.frc.robot.utils.Constants;

public class Field {

    private Texture fieldTexture;
    SpriteBatch batch;
    Rectangle score1, score2;//TODO take care of scoring shit

    public Field(SpriteBatch batch){
        fieldTexture = Constants.Field.fieldTexture;
        this.batch = batch;
    }

    public boolean isScore1Hit(){
        return false;
    }

    public boolean isScore2Hit(){
       return false;
    }

    public void draw(){
        batch.draw(fieldTexture, 0,0 , Constants.Field.width, Constants.Field.height);
    }
}
