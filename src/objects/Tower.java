package objects;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
/**
 * Superclass of Tower objects
 * @author Zoubair H
 *
 */
public class Tower extends Actor{
    private ArrayList<Enemy> targets = new ArrayList<Enemy>();
    protected long lastAttack = 0;
    protected Enemy target; 
    protected long coolDownTime;
    protected long radius; 
    protected double damage;
    protected Texture texture;
    protected Projectile projectile;
    protected Sprite sprite;
    protected Color radiusColor; 

    public Tower() {
    	super(); 
    }
    
    public void setDamage(float damage) {
    	this.damage = damage;
    }
    
    public double getDamage() {
    	return damage; 
    }
    
    public void setTarget(Enemy enemy) {
    	target = enemy; 
    }

    public Enemy getTarget(){
    	return target; 
    }
    
    public void checkTargets(Enemy target) { //Loops through all targets within its radius in order to determine which one is the closest    		
    	if (Math.sqrt( (Math.pow((target.getX()-getX()), 2)) + (Math.pow((target.getY()-getY()), 2))) < Math.sqrt(radius*radius))
        {
        	targets.add(target); 
        	setTarget(targets.get(0));
        	shoot(getTarget()); 
        	
        }
    	
		for (int i = 0; i < targets.size(); i++) 
		{
			if (Math.sqrt( (Math.pow((targets.get(i).getX()-getX()), 2)) + (Math.pow((targets.get(i).getY()-getY()), 2))) > Math.sqrt(radius*radius) || targets.get(i).getHealth() <= 0 || targets.get(i).getX()>800)
			{
				targets.remove(targets.get(i));
			}
		}
    }
    
    public void shoot(Enemy target) { //Shoots a projectile at the target   	
    	long time = System.currentTimeMillis();
        if (time > lastAttack + coolDownTime) {        	
        	float xSpeed = (target.getX() - getX())/8;
    		float ySpeed = (target.getY() - getY())/8;            
            if (projectile == null) {
                projectile = new Projectile(getX(), getY(), xSpeed, ySpeed, 3);
            }            
            lastAttack = time;
        }
    }
    
    public void update() { //Checks to see if projectile gets destroyed
        if(projectile != null) {
            projectile.update();
        }
    }
    
    public void render(Enemy target) {
        if(projectile != null) {
            projectile.update();     
            if (target.collides(projectile.getBounds())){
            	target.health -= damage; 
            }            
            if (target.collides(projectile.getBounds()) || Math.sqrt( (Math.pow((projectile.getX()-getX()), 2)) + (Math.pow((projectile.getY()-getY()), 2))) > Math.sqrt(radius*radius)) {
                projectile = null;
            }
        }       
    }
    
    public void draw(float x, float y, SpriteBatch sb) {
        if(projectile != null) {
            projectile.update();
            projectile.draw(sb);
        }
        if(getTarget()!=null) {
        	if(!sprite.isFlipX()){
            	if (getTarget().getX() < getX()) {
            		sprite.flip(true, false);
            	}
            }
            if (sprite.isFlipX()) {
            	if(getTarget().getX() > getX()){
            		sprite.flip(true, false);
            	}
            }
        } 
        sb.begin();
        sb.draw(sprite, getX() -12 , getY() - 13, 30, 30);
		sb.end();
    }
    
    public void drawRadius(ShapeRenderer shape, float x, float y) {
        shape.setColor(radiusColor);
        shape.circle(x, y, radius);
    }
}
