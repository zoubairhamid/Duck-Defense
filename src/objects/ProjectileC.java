package objects;

import com.badlogic.gdx.graphics.Texture;
/**
 * Subclass of Projectile
 * @author Zoubair H
 *
 */
public class ProjectileC extends Projectile{

	public ProjectileC(float x, float y, float xSpeed, float ySpeed, int size) {		
		super(x, y, xSpeed, ySpeed, size);
		texture = new Texture("assets/iceProjectile.png");		
	}

}