package objects;

import com.badlogic.gdx.graphics.Texture;
/**
 * Subclass of Enemy
 * @author DongHoon J
 *
 */
public class EnemyD extends Enemy{

	public EnemyD(float x, float y, int size) {
		super(x, y, size);
		health = 100; 
		speed = 2.1; 
		attack = 10; 
		texture = new Texture("assets/enemy4.png");
	}

}
