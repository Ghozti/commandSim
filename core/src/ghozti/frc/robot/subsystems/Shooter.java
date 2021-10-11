package ghozti.frc.robot.subsystems;

import com.badlogic.gdx.math.Rectangle;
import ghozti.frc.framework.frameworkutils.hardware.Projectile;

public class Shooter {

    boolean hasFired;
    float[] position;
    float width, height;
    Rectangle hitbox;
    Projectile projectile;

    public Shooter(float posx, float posy){
        hasFired = false;
        position[0] = posx;
        position[1] = posy;
        width = 50;
        height = 50;
        hitbox = new Rectangle(position[0],position[1],width,height);
        projectile = new Projectile(position[0],position[1]);
    }

    public void updateShooter(){

    }

    public void shoot(){
        
    }
}
