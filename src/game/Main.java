package game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.audio.Music;

import states.GameStateManager;
import states.MenuState;
/**
 * Initializes the first Game State
 * @author Zoubair H
 *
 */

public class Main extends ApplicationAdapter {
	private GameStateManager gsm;
    private SpriteBatch batch;
    private Music music; 
    
    public void create() {        
        batch = new SpriteBatch();
        gsm = new GameStateManager(); 
        gsm.push(new MenuState(gsm));
        
        music = Gdx.audio.newMusic(Gdx.files.internal("assets/duckMusic.mp3"));
        music.setLooping(true);
        music.setVolume(0.1f);
        music.play();
    }

    public void render() {   
    	gsm.update(Gdx.graphics.getDeltaTime());
    	gsm.render(batch);
    }
    
    public void dispose() {
    	music.dispose();
    }
}
