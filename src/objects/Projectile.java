package objects;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
/**
 * Superclass of projectile objects
 * @author Zoubair H
 *
 */
public class Projectile {
    private Projectile projectile;   
    private Rectangle bounds;   
    private Tower tower; 
    protected float x;
    protected float y;
    protected int size;
    protected float xSpeed;
    protected float ySpeed;
    protected Texture texture;

    public Projectile(float x, float y, float xSpeed, float ySpeed, int size) {
    	super(); 
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;        
        bounds = new Rectangle(x, y, size*2, size*2);
    }
    
    public void checkCollision(Enemy enemy) { //Checks collision with enemy
        if(collidesWith(enemy) || Math.sqrt( (Math.pow((projectile.getX()-getX()), 2)) + (Math.pow((projectile.getY()-getY()), 2))) > Math.sqrt(tower.radius*tower.radius)){
            projectile = null;
        }   
    }
    
    private boolean collidesWith(Enemy enemy) { 
       return Math.random()>.5;
    }
    
    public void update() { //Movement of projectile in order to hit mob
        x += xSpeed;
        y += ySpeed;
        
        bounds.setPosition(x, y);
    }
    
    public Rectangle getBounds() {
        return bounds; 
    }
    
    public void draw(SpriteBatch sb) {
    	sb.begin();
    	sb.draw(texture, getX()-6, getY(), 10,10);
    	sb.end();
    }
    
    public float getX() {
    	return x;
    }
    
    public float getY() {
    	return y; 
    }
    
}
