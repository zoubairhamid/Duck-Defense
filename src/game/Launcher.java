package game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Launcher {
	
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.height = 600;
		cfg.width = 800;
		cfg.foregroundFPS =0;
		LwjglApplication launcher = new LwjglApplication(new Main(), cfg);
	}
}