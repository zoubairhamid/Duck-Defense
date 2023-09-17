package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Starting screen
 * @author Zoubair H
 *
 */
public class MenuState extends State {
	
	private Texture background;
	
	public MenuState(GameStateManager gsm)
	{
		super(gsm); 
		background = new Texture("assets/menu.png");
	}

	public void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) 
		{
			gsm.set(new PlayState(gsm));
			dispose();
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.Q)) 
		{
			gsm.set(new HowToPlayStateOne(gsm));
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
