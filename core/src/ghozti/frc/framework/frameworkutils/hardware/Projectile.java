package ghozti.frc.framework.frameworkutils.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Projectile {

    float width, height;
    Texture projectileTexture;
    float[] coordinates;
    float[] shooterCoordinates;
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
        shooterCoordinates = new float[]{0,0};
    }

    public void setChange(float xchange, float ychange){
        //TODO fill this
    }

    public void updateShooterPos(float x, float y){
        shooterCoordinates[0] = x;
        shooterCoordinates[1] = y;
    }

    public void validatePos(){
        if (coordinates[0] < 0){
            coordinates[0] = shooterCoordinates[0];
        }else if(coordinates[0] > 1180){
            coordinates[0] = shooterCoordinates[0];
        }
        if (coordinates[1] < 0){
            coordinates[1] = shooterCoordinates[1];
        }else if(coordinates[1] > 620){
            coordinates[1] = shooterCoordinates[1];
        }

        hitbox.x = coordinates[0];
        hitbox.y = coordinates[1];
    }

    public void draw(Batch batch){
        batch.draw(projectileTexture, coordinates[0], coordinates[1], width, height);
    }

    public boolean getPastBounds(){
        return pastBounds;
    }
}
