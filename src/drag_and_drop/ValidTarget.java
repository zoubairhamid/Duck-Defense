package drag_and_drop;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target;
import objects.Gold;
import objects.Tower;
import objects.TowerA;
import objects.TowerB;
import objects.TowerC;
import objects.TowerD;
import objects.TowerE;
import objects.TowerF;
/**
 * Target created for the towers to be placed (valid drop)
 * @author DongHoon J
 *
 */
public class ValidTarget extends Target{
	private ArrayList<Tower> list;
	private Gold gold;
	private Sound placeSound = Gdx.audio.newSound(Gdx.files.internal("assets/towerPlaced.mp3"));
 
	public ValidTarget(Actor actor, ArrayList<Tower> list, Gold gold) {
		super(actor);
		this.gold = gold;
		this.list = list;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean drag(Source source, Payload payload, float x, float y, int pointer) {
		getActor().setColor(Color.GREEN);
		return true;
	}

	public void drop(Source source, Payload payload, float x, float y, int pointer) {//Allows placement of towers
		if(payload.getObject().equals("towerA") && gold.getGold() >= 15) {
			TowerA tower = new TowerA();
			tower.setPosition(getActor().getX() + (getActor().getWidth()/2), getActor().getY() + (getActor().getHeight()/2));
			placeSound.play(1.0f);
			list.add(tower);
			gold.addGold(-15);
		}
		else if(payload.getObject().equals("towerB") && gold.getGold() >= 25) {
			TowerB tower = new TowerB();
			tower.setPosition(getActor().getX() + (getActor().getWidth()/2), getActor().getY() + (getActor().getHeight()/2));
			placeSound.play(1.0f);
			list.add(tower);
			gold.addGold(-25);
		}
		else if(payload.getObject().equals("towerC") && gold.getGold() >= 40) {
			TowerC tower = new TowerC();
			tower.setPosition(getActor().getX() + (getActor().getWidth()/2), getActor().getY() + (getActor().getHeight()/2));
			placeSound.play(1.0f);
			list.add(tower);
			gold.addGold(-40);
		}
		else if(payload.getObject().equals("towerD") && gold.getGold() >= 50) {
			TowerD tower = new TowerD();
			tower.setPosition(getActor().getX() + (getActor().getWidth()/2), getActor().getY() + (getActor().getHeight()/2));
			placeSound.play(1.0f);
			list.add(tower);
			gold.addGold(-50);
		}
		else if(payload.getObject().equals("towerE") && gold.getGold() >= 100) {
			TowerE tower = new TowerE();
			tower.setPosition(getActor().getX() + (getActor().getWidth()/2), getActor().getY() + (getActor().getHeight()/2));
			placeSound.play(1.0f);
			list.add(tower);
			gold.addGold(-100);
		}
		else if(payload.getObject().equals("towerF") && gold.getGold() >= 175) {
			TowerF tower = new TowerF();
			tower.setPosition(getActor().getX() + (getActor().getWidth()/2), getActor().getY() + (getActor().getHeight()/2));
			placeSound.play(1.0f);
			list.add(tower);
			gold.addGold(-175);
		}
		
	}
	
	public void reset (Source source, Payload payload) {
		getActor().setColor(Color.WHITE);
	}

}
