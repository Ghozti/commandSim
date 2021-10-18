package ghozti.frc.framework.frameworkutils.hardware;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.frc.framework.frameworkutils.IO.ColorfulShell;
import ghozti.frc.robot.utils.Constants;

public class Projectile {

    float width, height;
    Texture projectileTexture;
    float[] coordinates;
    float[] shooterCoordinates;
    Rectangle hitbox;
    boolean shot, pastBounds,reset;

    public Projectile(float initx, float inity){
        projectileTexture = new Texture("ball.png");
        coordinates = new float[2];
        coordinates[0] = initx;
        coordinates[1] = inity;
        width = 50;
        height = 50;
        hitbox = new Rectangle(coordinates[0],coordinates[1],width,height);
        shooterCoordinates = new float[]{0,0};
    }

    public void update(float shooterx, float shootery){
        validatePos();

        if (shot){
            coordinates[0] += xChange;
            coordinates[1] += yChange;
            if (pastBounds){
                reset(shooterx,shootery);
            }
        }else {
            coordinates[0] = shooterx;
            coordinates[1] = shootery;
        }
    }

    float xChange, yChange;

    public void eject(String dir){//will take care of the projectile to move
        if (!shot) {
            switch (dir) {//dir = direction
                case "N":
                    yChange = Constants.Shooter.shootSpeed;
                    break;
                case "S":
                    yChange = -Constants.Shooter.shootSpeed;
                    break;
                case "E":
                    xChange = Constants.Shooter.shootSpeed;
                    break;
                case "W":
                    xChange = -Constants.Shooter.shootSpeed;
                    break;
            }
            shot = true;
        }
    }

    public void reset(float x, float y){//resets the projectile back into the shooter's position
        if (pastBounds){
            reset = true;
            coordinates[0] = x;
            coordinates[1] = y;
            hitbox.x = coordinates[0];
            hitbox.y = coordinates[1];
            xChange = 0;
            yChange = 0;
            shot = false;
            pastBounds = false;
        }
    }

    public void validatePos(){//will check if the projectile is out of bounds
        if (coordinates[0] < 0){
            pastBounds  = true;
        }else if(coordinates[0] > 1280){
            pastBounds  = true;
        }
        if (coordinates[1] < 0){
            pastBounds  = true;
        }else if(coordinates[1] > 720){
            pastBounds  = true;
        }
    }

    public void draw(Batch batch){
        batch.draw(projectileTexture, coordinates[0], coordinates[1], width, height);
    }

    public boolean getReset(){return reset;}
}
