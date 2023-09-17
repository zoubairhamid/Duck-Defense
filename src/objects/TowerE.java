package objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
/**
 * Subclass of Tower
 * @author Zoubair H
 *
 */
public class TowerE extends Tower{

	public TowerE() {
		super();
		coolDownTime = 2250;
	    radius = 75;  
	    damage = 30;
	    radiusColor = Color.YELLOW;
	    texture = new Texture("assets/duckE.png");
	    sprite = new Sprite(texture); 
	}
	
	public void shoot(Enemy target) { //Shoots a projectile at the target
    	long time = System.currentTimeMillis();
        if (time > lastAttack + coolDownTime) {       	
        	float xSpeed = (target.getX() - getX())/8;
    		float ySpeed = (target.getY() - getY())/8;             
            if (projectile == null) {
                projectile = new ProjectileE(getX(), getY(), xSpeed, ySpeed, 3);
            }            
            lastAttack = time;
        }
	}
	
	public void render(Enemy target) {
        if(projectile != null) {
            projectile.update();
            if (target.collides(projectile.getBounds())) {
            	target.health -= damage;   
            	target.speed = 0; 
            }
            if (target.collides(projectile.getBounds()) || Math.sqrt( (Math.pow((projectile.getX()-getX()), 2)) + (Math.pow((projectile.getY()-getY()), 2))) > Math.sqrt(radius*radius)) {
                projectile = null;
            }
        }        
    }
}