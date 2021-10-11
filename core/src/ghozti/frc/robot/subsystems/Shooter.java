package ghozti.frc.robot.subsystems;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import ghozti.frc.framework.frameworkutils.hardware.Projectile;
import ghozti.frc.robot.utils.Constants;

public class Shooter {

    boolean hasFired;
    String storedDirection;
    float vertexChange;
    float[] position;
    float width, height;
    Rectangle hitbox;
    Projectile projectile;
    final float projectileSpeedChange;
    boolean moveX, moveY;

    public Shooter(float posx, float posy){
        hasFired = false;
        position = new float[2];
        position[0] = posx;
        position[1] = posy;
        width = 50;
        height = 50;
        hitbox = new Rectangle(position[0],position[1],width,height);
        projectile = new Projectile(position[0],position[1]);
        projectileSpeedChange = Constants.Shooter.shootSpeed;
    }

    public void updateShooter(float x, float y, boolean moveX, boolean moveY){
        this.moveX = moveX;
        this.moveY = moveY;
        position[0] = x;
        position[1] = y;
        hitbox.x = position[0];
        hitbox.y = position[1];
    }

    public void shoot(String direction){
        if (!hasFired) {
            storedDirection = direction;
            hasFired = true;
        }else {
            if (storedDirection.equals("W") || storedDirection.equals("E")){
                if (storedDirection.equals("W")){
                    projectile.update(-projectileSpeedChange,0);
                }else {
                    projectile.update(projectileSpeedChange,0);
                }
            }else if(storedDirection.equals("N") || storedDirection.equals("S")){
                if (storedDirection.equals("N")){
                    projectile.update(0,projectileSpeedChange);
                }else {
                    projectile.update(0,-projectileSpeedChange);
                }
            }
        }
    }

    public void drawProjectile(Batch batch){
        projectile.draw(batch);
    }
}
