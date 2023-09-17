package objects;

import com.badlogic.gdx.graphics.Texture;
/**
 * Subclass of Enemy
 * @author DongHoon J
 *
 */
public class EnemyA extends Enemy{

	public EnemyA(float x, float y, int size) {
		super(x, y, size);
		health = 100; 
		speed = 1.3; 
		attack = 5; 
		texture = new Texture("assets/enemy.png");
	}

}
