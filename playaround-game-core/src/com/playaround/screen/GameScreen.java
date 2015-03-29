package com.playaround.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.playaround.entity.Bullet;
import com.playaround.entity.Player;
import com.playaround.game.playaround_game;

public class GameScreen implements Screen{
	Player player;
	public static List<Bullet> bulletList = new ArrayList<Bullet>();
	int score = 0;
	BitmapFont font = new BitmapFont();
	
	public GameScreen () {
		player = new Player();
	}

	public void render(float dt) {
		Update(dt);
		Draw(dt);
	}

	void Update(float dt) {
		player.Update(dt);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).Update(dt);
		}
		
		if (bulletList.isEmpty()) {
			score = 0;
		} else {
			score = bulletList.size();
		}
		
		if (player.dead) {
			if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
				ScreenManager.getInstance().swapToScreen(new MainMenu());
			}
		}
		
		//Check Collisions
		CheckCollisions();
	}
	
	void CheckCollisions() {
		float shipSize = player.shipWidth();
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = bulletList.get(i);
			float a = player.sprite.getX();
			float b = player.sprite.getY();
			float y = bullet.sprite.getX();
			float z = bullet.sprite.getY();
			float distance = (float) Math.sqrt((a-y)*(a-y)+(b-z)*(b-z));
			if (distance < shipSize) {
				KillPlayer();
			}
		}
	}
	
	void KillPlayer() {
		if (player != null) {
			if (!player.dead) {
			player.dead = true;
			}
		}
	}
	
	void Draw(float dt) {
		SpriteBatch sb = playaround_game.batch;
		player.draw(sb);
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).draw(sb);
		}
		
		if (!player.dead) {
			font.draw(sb, "Score: " + score, 0, Gdx.graphics.getHeight() - 20);
		} else {
			font.draw(sb, "You got " + score + " points!", Gdx.graphics.getWidth()/2 - 60, Gdx.graphics.getHeight()/2 + 20);
			font.draw(sb, "Press ESC to go back to the main menu", Gdx.graphics.getWidth()/2 - 120, Gdx.graphics.getHeight()/2 - 20);
		}
	}
	

	public static void addBullet(Bullet inBullet) {
		bulletList.add(inBullet);
	}
	
	public void show() {bulletList.clear();}
	public void hide() {}
	public void dispose() {	}
	public void pause() {}
	public void resize(int x, int y) {}
	public void resume() {}
}
