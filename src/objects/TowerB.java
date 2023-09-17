package objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
/**
 * Subclass of Tower
 * @author Zoubair H
 *
 */
public class TowerB extends Tower{
	
	public TowerB() {
		super();
		coolDownTime = 400;
	    radius = 85;  
	    damage = 15;
	    radiusColor = Color.RED;
	    texture = new Texture("assets/duckB.png");
	    sprite = new Sprite(texture); 
	}
	
	public void shoot(Enemy target) { //Shoots a projectile at the target
    	long time = System.currentTimeMillis();
        if (time > lastAttack + coolDownTime) {
        	float xSpeed = (target.getX() - getX())/8;
    		float ySpeed = (target.getY() - getY())/8; 
            if (projectile == null) {
                projectile = new ProjectileB(getX(), getY(), xSpeed, ySpeed, 3);
            }            
            lastAttack = time;
        }
	}
}
