package objects;

import com.badlogic.gdx.graphics.Texture;
/**
 * Subclass of Enemy
 * @author DongHoon J
 *
 */
public class EnemyB extends Enemy{

	public EnemyB(float x, float y, int size) {
		super(x, y, size);
		health = 150; 
		speed = 1.7; 
		attack = 8; 
		texture = new Texture("assets/enemy2.png");
	}

}
