package waves;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import objects.Enemy;
import objects.EnemyA;
import objects.EnemyB;
import objects.EnemyC;
import objects.EnemyD;
import objects.EnemyE;
import objects.EnemyF;
/**
 * Class in charge of all Waves of Enemies
 * @author DongHoon J
 *
 */
public class Wave {
	final private int initialY = 325;
	protected ArrayList<Enemy> wave = new ArrayList<Enemy>();
	private BitmapFont waveFont;
	private WaveNumber current = WaveNumber.ONE;
	private int currentWave;
	
	public Wave() {
		waveFont = new BitmapFont();
		waveFont.setColor(Color.BLUE);
	}
	
	public ArrayList<Enemy> getWave(){
		return wave;
	}
	public WaveNumber getWaveNumber() {
		return current;
	}
	
	public void waveManagement() { //Creates and manages waves
		if(current == WaveNumber.ONE) {
			if(wave.size() == 0) {
				setupWave2();
				current = WaveNumber.TWO;
			}
		}
		else if(current == WaveNumber.TWO) {
			if(wave.size() == 0) {
				setupWave3();
				current = WaveNumber.THREE;
			}
		}
		else if(current == WaveNumber.THREE) {
			if(wave.size() == 0) {
				setupWave4();
				current = WaveNumber.FOUR;
			}
		}
		else if(current == WaveNumber.FOUR) {
			if(wave.size() == 0) {
				setupWave5();
				current = WaveNumber.FIVE;
			}
		}
		else if(current == WaveNumber.FIVE) {
			if(wave.size() == 0) {
				setupWave6();
				current = WaveNumber.SIX;
			}
		}
		else if(current == WaveNumber.SIX) {
			if(wave.size() == 0) {
				setupWave7();
				current = WaveNumber.SEVEN;
			}
		}
		else if(current == WaveNumber.SEVEN) {
			if(wave.size() == 0) {
				setupWave8();
				current = WaveNumber.EIGHT;
			}
		}
		else if(current == WaveNumber.EIGHT) {
			if(wave.size() == 0) {
				setupWave9();
				current = WaveNumber.NINE;
			}
		}
		else if(current == WaveNumber.NINE) {
			if(wave.size() == 0) {
				setupWave10();
				current = WaveNumber.TEN;
			}
		}
		else if(current == WaveNumber.TEN) {
			if(wave.size() == 0) {
				current = WaveNumber.COMPLETE;
			}
		}
	}
	
	public void setupWave1() {
		currentWave++;
		for(int i = 0; i > -1000; i-=100) {
			EnemyA enemy = new EnemyA(i , initialY ,5); 
			wave.add(enemy);
		}
	}	
	public void setupWave2() {
		currentWave++;
		for(int i = 0; i > -1000;  i -= 100) {
			if(i > -500) {
				EnemyA enemy = new EnemyA(i , initialY ,5); 
				wave.add(enemy);
			}
			else {
				EnemyB enemy = new EnemyB(i , initialY,5); 
				wave.add(enemy);
			}
		}
	}	
	public void setupWave3() {
		currentWave++;
		for(int i = 0; i > -1500;  i -= 100) {
			EnemyB enemy = new EnemyB(i , initialY,5); 
			wave.add(enemy);
		}
	}	
	public void setupWave4() {
		currentWave++;
		for(int i = 0; i > -700;  i -= 100) {
			EnemyC enemy = new EnemyC(i , initialY,5); 
			wave.add(enemy);
		}
	}
	public void setupWave5() {
		currentWave++;
		for(int i = 0; i > -1500;  i -= 100) {
			if(i > -500) {
				EnemyC enemy = new EnemyC(i , initialY,5); 
				wave.add(enemy);
			}
			else {
				EnemyD enemy = new EnemyD(i, initialY, 5);
				wave.add(enemy);
			}
		}
	}
	public void setupWave6() {
		currentWave++;
		for(int i = 0; i > -2000;  i -= 100) {
			EnemyD enemy = new EnemyD(i , initialY,5); 
			wave.add(enemy);
		}
	}
	public void setupWave7() {
		currentWave++;
		for(int i = 0; i > -1000;  i -= 100) {
			EnemyE enemy = new EnemyE(i , initialY,5); 
			wave.add(enemy);
		}
	}
	public void setupWave8() {
		currentWave++;
		for(int i = 0; i > -1500;  i -= 100) {
			if(i > -300) {
				EnemyC enemy = new EnemyC(i , initialY,5); 
				wave.add(enemy);
			}
			else if(i > -1000) {
				EnemyD enemy = new EnemyD(i , initialY,5); 
				wave.add(enemy);
			}
			else {
				EnemyE enemy = new EnemyE(i , initialY,5); 
				wave.add(enemy);
			}
		}
	}
	public void setupWave9() {
		currentWave++;
		for(int i = 0; i > -1000;  i -= 100) {
			EnemyF enemy = new EnemyF(i , initialY,5); 
			wave.add(enemy);
		}
	}
	public void setupWave10() {
		currentWave++;
		for(int i = 0; i > -2500;  i -= 100) {
			if(i > -1000) {
				EnemyE enemy = new EnemyE(i , initialY,5); 
				wave.add(enemy);
			}
			else {
				EnemyF enemy = new EnemyF(i, initialY, 5);
				wave.add(enemy);
			}
		}
	}
	
	public void draw(SpriteBatch batch) {
		waveFont.draw(batch, ("Wave : " + String.valueOf(currentWave) + " / 10"), 50, 70);
	}

}
