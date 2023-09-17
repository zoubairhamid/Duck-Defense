package states;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import drag_and_drop.InvalidTarget;
import drag_and_drop.PayloadManager;
import drag_and_drop.ValidTarget;
import objects.Enemy;
import objects.EnemyA;
import objects.EnemyB;
import objects.EnemyC;
import objects.EnemyD;
import objects.EnemyE;
import objects.Gold;
import objects.PlayerHealth;
import objects.Tower;
import waves.Wave;
import waves.WaveNumber;
/**
 * Main state where the game is played
 * @author DongHoon J & Zoubair H
 */

public class PlayState extends State {

	private ShapeRenderer shape;
	private Stage stage;
	private Texture menuBar; 
	private SpriteBatch batch;
	private ArrayList<Tower> towers = new ArrayList<Tower>();
	private Wave wave = new Wave();
	private Gold gold;
	private PlayerHealth health; 
	private Sound takeDamageSound = Gdx.audio.newSound(Gdx.files.internal("assets/damageTaken.mp3"));
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
		batch = new SpriteBatch();
		menuBar = new Texture("assets/menuBar.png"); 
		shape = new ShapeRenderer();
		gold = new Gold(50);
		health = new PlayerHealth(100); 
		createMap();
		wave.setupWave1();
	}

	@Override
	protected void handleInput() {

	}

	@Override
	public void update(float dt) {
		handleInput();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.draw(menuBar, 0, 0, 800, 100);
		sb.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		batch.begin();
		shape.begin(ShapeRenderer.ShapeType.Filled);
		wave.draw(batch);
		gold.draw(batch);
		health.draw(batch);
		wave.waveManagement();
		findingTarget();
		batch.end();
		shape.end();
		makeRadius(sb);
		if(health.getPlayerHealth() <= 0) { //When player health = 0
			gsm.set(new GameOverState(gsm));
			dispose();
		}
		if(wave.getWaveNumber() == WaveNumber.COMPLETE) { //When all waves complete
			gsm.set(new WinState(gsm));
			dispose();
		}
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	public void makeRadius(SpriteBatch sb) { //Draws radius around the towers created
		for (int i = 0; i < towers.size(); i++) {
			Tower currentTower = towers.get(i);
			shape.begin(ShapeRenderer.ShapeType.Filled);
			currentTower.draw(currentTower.getX() - 20, currentTower.getY(), sb);
			shape.end();
			shape.begin(ShapeRenderer.ShapeType.Line);
			currentTower.drawRadius(shape, currentTower.getX(), currentTower.getY());
			shape.end();
			currentTower.render(towers.get(i).getTarget());
		}
	}

	public void createMap() { //Creates the map for DragAndDrop capabilities
		final Skin skin = new Skin();
		int[][] mapLayout = {	{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
								{ 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2, 2, 2, 2 }, 
								{ 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2 },
								{ 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2 }, 
								{ 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 1 },
								{ 1, 1, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2 }, 
								{ 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2 },
								{ 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2 }, 
								{ 2, 2, 2, 2, 2, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 2 },
								{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 } };

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		skin.add("default", new LabelStyle(new BitmapFont(), Color.WHITE));
		skin.add("path", new Texture("assets/path.png"));
		skin.add("grass", new Texture("assets/grass.png"));
		skin.add("towerA", new Texture("assets/duckA.png"));
		skin.add("towerB", new Texture("assets/duckB.png"));
		skin.add("towerC", new Texture("assets/duckC.png"));
		skin.add("towerD", new Texture("assets/duckD.png"));
		skin.add("towerE", new Texture("assets/duckE.png"));
		skin.add("towerF", new Texture("assets/duckF.png"));
		Image sourceTower1 = new Image(skin, "towerA");
		sourceTower1.setBounds(200, 20, 50, 50);
		stage.addActor(sourceTower1);
		Image sourceTower2 = new Image(skin, "towerB");
		sourceTower2.setBounds(310, 20, 50, 50);
		stage.addActor(sourceTower2);
		Image sourceTower3 = new Image(skin, "towerC");
		sourceTower3.setBounds(410, 20, 50, 50);
		stage.addActor(sourceTower3);
		Image sourceTower4 = new Image(skin, "towerD");
		sourceTower4.setBounds(510, 20, 50, 50);
		stage.addActor(sourceTower4);
		Image sourceTower5 = new Image(skin, "towerE");
		sourceTower5.setBounds(620, 20, 50, 50);
		stage.addActor(sourceTower5);
		Image sourceTower6 = new Image(skin, "towerF");
		sourceTower6.setBounds(720, 20, 50, 50);
		stage.addActor(sourceTower6);
		
		DragAndDrop dragAndDrop = new DragAndDrop();
		dragAndDrop.addSource(new PayloadManager(sourceTower1, skin, dragAndDrop, stage, "towerA"));
		dragAndDrop.addSource(new PayloadManager(sourceTower2, skin, dragAndDrop, stage, "towerB"));
		dragAndDrop.addSource(new PayloadManager(sourceTower3, skin, dragAndDrop, stage, "towerC"));
		dragAndDrop.addSource(new PayloadManager(sourceTower4, skin, dragAndDrop, stage, "towerD"));
		dragAndDrop.addSource(new PayloadManager(sourceTower5, skin, dragAndDrop, stage, "towerE"));
		dragAndDrop.addSource(new PayloadManager(sourceTower6, skin, dragAndDrop, stage, "towerF"));
		
		for (int i = 0; i < mapLayout.length; i++) {
			for (int r = 0; r < mapLayout[i].length; r++) {
				if (mapLayout[i][r] == 2) {
					Image validTarget = new Image(skin, "grass");
					validTarget.setBounds(r * 50, 550 - (i * 50), 50, 50);
					stage.addActor(validTarget);
					dragAndDrop.addTarget(new ValidTarget(validTarget, towers, gold));
				} else if (mapLayout[i][r] == 1) {
					Image invalidTarget = new Image(skin, "path");
					invalidTarget.setBounds(r * 50, 550 - (i * 50), 50, 50);
					stage.addActor(invalidTarget);
					dragAndDrop.addTarget(new InvalidTarget(invalidTarget));
				}
			}
		}
	}

	public void findingTarget() { //Draws and finds Targets in the wave of enemies
		for (int r = 0; r < wave.getWave().size(); r++) {
			Enemy enemy = wave.getWave().get(r);
			enemy.draw(batch, shape);
			enemy.update();
			for (int x = 0; x < towers.size(); x++) {
				towers.get(x).checkTargets(enemy);
				if (towers.get(x).getTarget() == null || towers.get(x).getTarget().getHealth() <= 0 || towers.get(x).getTarget().getX() > 790) {
					towers.get(x).setTarget(enemy);
				}
			}
			if (enemy.getHealth() <= 0) {
				if(enemy instanceof EnemyA) {
					gold.addGold(5);
				}
				else if(enemy instanceof EnemyB) {
					gold.addGold(10);
				}
				else if(enemy instanceof EnemyC) {
					gold.addGold(15);
				}
				else if(enemy instanceof EnemyD) {
					gold.addGold(15);
				}
				else if(enemy instanceof EnemyE) {
					gold.addGold(20);
				}
				else{
					gold.addGold(25);
				}
				wave.getWave().remove(r);
			}
			
			if (enemy.getX() > 800) 
			{
				health.takeDamage(enemy.getAttack());
				takeDamageSound.play(1.0f);
				wave.getWave().remove(r); 
			}
		}
	}

}