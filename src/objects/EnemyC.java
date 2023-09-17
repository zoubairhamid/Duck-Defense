package objects;

import com.badlogic.gdx.graphics.Texture;
/**
 * Subclass of Enemy
 * @author DongHoon J
 *
 */
public class EnemyC extends Enemy{

	public EnemyC(float x, float y, int size) {
		super(x, y, size);
		health = 800; 
		speed = 0.6; 
		attack = 30; 
		texture = new Texture("assets/enemy3.png");
	}

}
