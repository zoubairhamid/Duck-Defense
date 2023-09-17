package objects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 * Class to keep track of gold and income
 * @author DongHoon J
 *
 */
public class Gold {
	private int gold;
	private BitmapFont goldFont;
	
	public Gold(int amount) {
		this.gold = amount;
		goldFont = new BitmapFont();
		goldFont.setColor(Color.GOLD);
	}
	
	public int getGold() {
		return gold;
	}
	
	public void addGold(int amount) { //Adds gold to the total
		gold += amount;
	}
	
	public void draw(SpriteBatch batch) {
		goldFont.draw(batch, ("Gold : " + String.valueOf(getGold())), 50, 40);
	}

}
