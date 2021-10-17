package ghozti.frc.framework.frameworkutils.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.frc.robot.utils.Constants;

public class Projectile {

    float width, height;
    Texture projectileTexture;
    float[] coordinates;
    float[] shooterCoordinates;
    Rectangle hitbox;
    boolean pastBounds,reset;

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

    public void update(float shooterx, float shootery){
        validatePos();
        if (pastBounds){
            reset(shooterx,shootery);
        }
    }

    public void eject(String dir){//will take care of the projectile to move
        switch (dir){//dir = direction
            case "N":
                coordinates[1] += Constants.Shooter.shootSpeed;
                break;
            case "S":
                coordinates[1] -= Constants.Shooter.shootSpeed;
                break;
            case "E":
                coordinates[0] += Constants.Shooter.shootSpeed;
                break;
            case "W":
                coordinates[0] -= Constants.Shooter.shootSpeed;
                break;
        }
    }

    public void reset(float x, float y){//resets the projectile back into the shooter's position
        if (pastBounds){
            reset = true;
            coordinates[0] = x;
            coordinates[1] = y;
            hitbox.x = coordinates[0];
            hitbox.y = coordinates[1];
        }
    }

    public void validatePos(){//will check if the projectile is out of bounds
        if (coordinates[0] < 0){
            pastBounds  = true;
        }else if(coordinates[0] > 1180){
            pastBounds  = true;
        }
        if (coordinates[1] < 0){
            pastBounds  = true;
        }else if(coordinates[1] > 620){
            pastBounds  = true;
        }
    }

    public void draw(Batch batch){
        batch.draw(projectileTexture, coordinates[0], coordinates[1], width, height);
    }

    public boolean getReset(){return reset;}
}
