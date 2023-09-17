package objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 * Class to keep track of health and loss
 * @author Zoubair H
 *
 */
public class PlayerHealth {
	private int playerHealth;
	private BitmapFont playerHealthFont;
	
	public PlayerHealth(int amount) {
		this.playerHealth = amount;
		playerHealthFont = new BitmapFont();
		playerHealthFont.setColor(Color.RED);
	}
	
	public int getPlayerHealth() {
		return playerHealth;
	}
	
	public void takeDamage(int amount) { //Lose health
		playerHealth -= amount;
	}
	
	public void draw(SpriteBatch batch) {
		playerHealthFont.draw(batch, ("Health : " + String.valueOf(getPlayerHealth())), 50, 55);
	}

}
