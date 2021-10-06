package ghozti.frc.framework.frameworkutils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ghozti.frc.robot.utils.Constants;

public class Field {

    private Texture fieldTexture;
    SpriteBatch batch;

    public Field(SpriteBatch batch){
        fieldTexture = Constants.Field.fieldTexture;
        this.batch = batch;
    }

    public void draw(){
        batch.draw(fieldTexture, 0,0 , Constants.Field.width, Constants.Field.height);
    }
}
