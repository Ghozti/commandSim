package ghozti.frc.robot.subsystems;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.frc.framework.frameworkutils.hardware.Projectile;
import ghozti.frc.robot.utils.Constants;

public class Shooter {

    String storedDirection;
    float vertexChange;
    float[] position;
    float width, height;
    Rectangle hitbox;
    Projectile projectile;
    final float projectileSpeedChange;
    boolean hasFired;

    public Shooter(float posx, float posy){
        position = new float[2];
        position[0] = posx;
        position[1] = posy;
        width = 50;
        height = 50;
        hitbox = new Rectangle(position[0],position[1],width,height);
        projectile = new Projectile(position[0],position[1]);
        projectileSpeedChange = Constants.Shooter.shootSpeed;
        hasFired = false;
    }

    public void updateShooter(float x, float y){
        position[0] = x;
        position[1] = y;
        hitbox.x = position[0];
        hitbox.y = position[1];
        projectile.update(position[0],position[1]);
    }

    public void shoot(String direction){
        if (!hasFired) {
            storedDirection = direction;
            projectile.eject(direction);
            hasFired = true;
        }

        if (projectile.getReset()){
            hasFired = false;
        }

    }

    public void drawProjectile(Batch batch){
        projectile.draw(batch);
    }
}
