package com.playaround.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.playaround.game.playaround_game;

public class GameScreen implements Screen{
	Texture background;
	float xPos = 0.0f;
	float yPos = 0.0f;
	
	public GameScreen () {
		background = new Texture(playaround_game.selectedBackground);
	}

	public void render(float dt) {
		Update(dt);
		Draw(dt);
	}

	void Update(float dt) {
		float speed = 50.0f;
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			yPos -= dt * speed;
		} 
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			yPos += dt * speed;
		}		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			xPos -= dt * speed;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			xPos += dt * speed;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			ScreenManager.getInstance().swapToScreen(new MainMenu());
		}
	}
	
	void Draw(float dt) {
		SpriteBatch sb = playaround_game.batch;
		sb.draw(background, (Gdx.graphics.getWidth() / 2) - (background.getWidth() / 2) + xPos, (Gdx.graphics.getHeight() / 2) - (background.getHeight() / 2) + yPos);
	}
	
	public void show() {}
	public void hide() {}
	public void dispose() {}
	public void pause() {}
	public void resize(int x, int y) {}
	public void resume() {}
}
