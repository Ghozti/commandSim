package ghozti.frc.framework.frameworkutils.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {

    float width, height;
    Texture projectileTexture;
    float[] coordinates;
    Rectangle hitbox;
    boolean pastBounds;

    public Projectile(float initx, float inity){
        projectileTexture = new Texture("ball.png");
        coordinates = new float[2];
        coordinates[0] = initx;
        coordinates[1] = inity;
        width = 50;
        height = 50;
        hitbox = new Rectangle(coordinates[0],coordinates[1],width,height);
        pastBounds = false;
    }

    public void setChange(float xchange, float ychange){
        //TODO fill this
    }

    public void setPosition(float x, float y){
        coordinates[0] = x;
        coordinates[1] = y;
        hitbox.x = coordinates[0];
        hitbox.y = coordinates[1];
    }

    public void validatePos(){
        if (coordinates[0] < 0){
            coordinates[0] = 0;
        }else if(coordinates[0] > 1180){
            coordinates[0] = 1180;
        }
        if (coordinates[1] < 0){
            coordinates[1] = 0;
        }else if(coordinates[1] > 620){
            coordinates[1] = 620;
        }
    }

    public void draw(Batch batch){
        batch.draw(projectileTexture, coordinates[0], coordinates[1], width, height);
    }

    public boolean getPastBounds(){
        return pastBounds;
    }
}
