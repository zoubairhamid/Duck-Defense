package objects;

import com.badlogic.gdx.graphics.Texture;
/**
 * Subclass of Enemy
 * @author DongHoon J
 *
 */
public class EnemyE extends Enemy{

	public EnemyE(float x, float y, int size) {
		super(x, y, size);
		health = 800; 
		speed = 1.5; 
		attack = 12; 
		texture = new Texture("assets/enemy5.png");
	}

}
