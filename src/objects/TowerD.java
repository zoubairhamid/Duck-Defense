package objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
/**
 * Subclass of Tower
 * @author Zoubair H
 *
 */
public class TowerD extends Tower{
	
	public TowerD(){ 
		super();
		coolDownTime = 4500;
	    radius = 1000;  
	    damage = 100;
	    radiusColor = Color.BLACK;
	    texture = new Texture("assets/duckD.png");
	    sprite = new Sprite(texture); 
	}
	
	public void shoot(Enemy target) { //Shoots a projectile at the target
	    long time = System.currentTimeMillis();
	    if (time > lastAttack + coolDownTime) {
	    	float xSpeed = (target.getX() - getX())/8;
	    	float ySpeed = (target.getY() - getY())/8; 
	        if (projectile == null) {
	        	projectile = new ProjectileD(getX(), getY(), xSpeed, ySpeed, 3);
	        } 
	        lastAttack = time;
	        }
	 }
}
