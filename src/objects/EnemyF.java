package objects;

import com.badlogic.gdx.graphics.Texture;
/**
 * Subclass of Enemy
 * @author DongHoon J
 *
 */
public class EnemyF extends Enemy{

	public EnemyF(float x, float y, int size) {
		super(x, y, size);
		health = 600; 
		speed = 2; 
		attack = 15; 
		texture = new Texture("assets/enemy6.png");
	}

}
