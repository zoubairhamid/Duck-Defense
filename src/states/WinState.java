package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 * Winner Screen State
 * @author Zoubair H
 *
 */
public class WinState extends State {
	
	private Texture background;
	
	public WinState(GameStateManager gsm)
	{
		super(gsm); 
		background = new Texture("assets/win.jpg");
	}

	public void handleInput() {
		if (Gdx.input.isKeyPressed(Keys.ENTER)) 
		{
			gsm.set(new MenuState(gsm));
			dispose();
		}
	}
	
	public void update(float dt) {
		handleInput(); 
	}
	
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(background, 0, 0, 800, 600);
		sb.end(); 
	}
	
	public void dispose() 
	{
		background.dispose(); 
	}

}
