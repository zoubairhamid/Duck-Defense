package objects;

import com.badlogic.gdx.graphics.Texture;
/**
 * Subclass of Projectile
 * @author Zoubair H
 *
 */
public class ProjectileE extends Projectile{

	public ProjectileE(float x, float y, float xSpeed, float ySpeed, int size) {		
		super(x, y, xSpeed, ySpeed, size);
		texture = new Texture("assets/lightningProjectile.png");		
	}

}