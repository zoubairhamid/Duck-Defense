package states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 * Instruction#4 State
 * @author Zoubair H
 *
 */
public class HowToPlayStateFour extends State {
	
	private Texture image;
	
	public HowToPlayStateFour(GameStateManager gsm)
	{
		super(gsm); 
		
		image = new Texture("assets/howToFour.png");
	}

	public void handleInput() {
		if (Gdx.input.isKeyJustPressed(Keys.BACKSPACE)) 
		{
			gsm.set(new HowToPlayStateThree(gsm));
			dispose();
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.ENTER)) 
		{
			gsm.set(new PlayState(gsm));
			dispose();
		}
		
	}
	
	public void update(float dt) {
		handleInput(); 
	}
	
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(image, 0, 0, 800, 600);
		sb.end(); 
	}
	
	public void dispose() 
	{
		image.dispose(); 
	}

}