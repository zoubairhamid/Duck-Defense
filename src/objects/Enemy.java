package objects;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
/**
 * Superclass of Enemy objects
 * @author DongHoon J
 *
 */
public class Enemy {
    private Rectangle bounds;
    private BitmapFont healthFont;
    protected float x;
    protected float y;
    protected int size;  
    protected float health; 
    protected double speed; 
    protected int attack; 
    protected Texture texture;
    
    public Enemy(float x, float y, int size) {
    	super(); 
        this.x = x;
        this.y = y;
        this.size = size;
        healthFont = new BitmapFont();
		healthFont.setColor(Color.RED);
        bounds = new Rectangle(x, y, size*2, size*2);
    }
    
    public void update() {
        movement();
        bounds.setPosition(x, y); 
    }
    
    public void draw(SpriteBatch sb, ShapeRenderer shape) {
    	healthFont.draw(sb, String.valueOf(getHealth()), getX()-8, getY() + 25);
		sb.draw(texture, getX()-6, getY()-5, 15, 15);
    }
   
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public float getHealth() {
    	return health; 
    }
    
    public int getAttack() {
    	return attack; 
    }
    
    public boolean collides(Rectangle projectile){ //Checks if colliding with a projectile
        return projectile.overlaps(bounds); 
    }
    
    private void movement() { //Movement through the map
    	if(this.getX() < 125) {
    		x += speed; 
    	}
    	else if(this.getY() < 525 && this.getX() < 275) {
    		y += speed;
    	}
    	else if(this.getX() < 275) {
    		x += speed;
    	}
    	else if(this.getY() > 175 && this.getX() < 425) {
    		y -= speed;
    	}
    	else if(this.getX() < 425){
    		x += speed;
    	}
    	else if(this.getY() < 525 && this.getX() < 575) {
    		y += speed;
    	}
    	else if(this.getX() < 575) {
    		x += speed;
    	}
    	else if(this.getY() > 175 && this.getX() < 725) {
    		y -= speed;
    	}
    	else if(this.getX() < 725) {
    		x += speed;
    	}
    	else if(this.getY() < 375) {
    		y += speed;
    	}
    	else {
    		x += speed;
    	}
    }
}
