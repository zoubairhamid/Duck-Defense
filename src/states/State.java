package states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
/**
 * Abstract class for all States
 * @author Zoubair H
 *
 */
public abstract class State {
	
	protected GameStateManager gsm; 
	
	protected State(GameStateManager gsm)
	{
		this.gsm = gsm;
	}
	
	/**
	 * Handles all possible inputs in the state
	 */
	protected abstract void handleInput();
	
	/**
	 * Updates the state
	 */
	public abstract void update(float dt);
	
	/**
	 * Renders game state
	 * Makes things appear on screen
	 */
	public abstract void render(SpriteBatch sb);
	
	/**
	 * Dispose of objects to reduce lag and bugs
	 */
	public abstract void dispose(); 
}
