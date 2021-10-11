package ghozti.frc.framework.frameworkutils.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {

    float width, height;
    Texture projectileTexture;
    float[] position;
    Rectangle hitbox;
    boolean pastBounds;

    public Projectile(float initx, float inity){
        projectileTexture = new Texture("ball.png");
        position = new float[2];
        position[0] = initx;
        position[1] = inity;
        width = 50;
        height = 50;
        hitbox = new Rectangle(position[0],position[1],width,height);
        pastBounds = false;
    }

    public void update(float xchange, float ychange){
        position[0] += xchange;
        position[1] += ychange;
        hitbox.x = position[0];
        hitbox.y = position[1];
    }

    public void setPosition(float x, float y){
        position[0] = x;
        position[1] = y;
        hitbox.x = position[0];
        hitbox.y = position[1];
    }

    public void draw(Batch batch){
        batch.draw(projectileTexture, position[0], position[1], width, height);
    }

    public boolean getPastBounds(){
        return pastBounds;
    }
}
