package objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
/**
 * Subclass of Tower
 * @author Zoubair H
 *
 */
public class TowerA extends Tower{
    
    public TowerA() {
		super();
		coolDownTime = 200;
	    radius = 85;  
	    damage = 5;
	    radiusColor = Color.BLACK;
	    texture = new Texture("assets/duckA.png");
	    sprite = new Sprite(texture); 
	}
    
	public void shoot(Enemy target) { //Shoots a projectile at the target
	    	long time = System.currentTimeMillis();
	        if (time > lastAttack + coolDownTime) {
	        	float xSpeed = (target.getX() - getX())/8;
	    		float ySpeed = (target.getY() - getY())/8; 
	            if (projectile == null){
	                projectile = new ProjectileA(getX(), getY(), xSpeed, ySpeed, 3);
	            }
	            lastAttack = time;
	        }
	 }
}
