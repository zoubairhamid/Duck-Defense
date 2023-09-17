package objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
/**
 * Subclass of Tower
 * @author Zoubair H
 *
 */
public class TowerF extends Tower{
	
	public TowerF(){ 
		super();
		coolDownTime = 750;
	    radius = 125;  
	    damage = 100;
	    radiusColor = Color.WHITE;
	    texture = new Texture("assets/duckF.png");
	    sprite = new Sprite(texture); 
	}
	
	public void shoot(Enemy target) { //Shoots a projectile at the target
	    long time = System.currentTimeMillis();
	    if (time > lastAttack + coolDownTime) {
	        float xSpeed = (target.getX() - getX())/8;
	    	float ySpeed = (target.getY() - getY())/8;   
	        if (projectile == null)  {
	                projectile = new ProjectileF(getX(), getY(), xSpeed, ySpeed, 3);
	            }
	        lastAttack = time;
	        }
	 }
}