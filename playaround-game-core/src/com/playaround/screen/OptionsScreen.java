package com.playaround.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.playaround.game.playaround_game;
import com.playaround.menu.BackgroundSelectionButton;
import com.playaround.menu.UIButton;

public class OptionsScreen implements Screen{
	BitmapFont font = new BitmapFont();
	List<UIButton> buttonList = new ArrayList<UIButton>();
	int selectedButtonList = 0;
	
	public OptionsScreen() {
		for (int i = 0; i < playaround_game.backgroundList.size(); i++) {
			buttonList.add(new BackgroundSelectionButton(playaround_game.backgroundList.get(i), buttonList.size(), isFirst()));
		}
	}
	
	boolean isFirst() {
		if (buttonList.isEmpty()) {return true;}
		return false;
	}
	
	public void render(float dt) {
		Update(dt);
		Draw(dt);
	}
	
	void Update(float dt) {
		if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
			//Down
			if (selectedButtonList < buttonList.size() - 1) {
				buttonList.get(selectedButtonList).deselect();
				selectedButtonList++;
				buttonList.get(selectedButtonList).select();
			}
		} else if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
			//Up
			if (selectedButtonList > 0) {
				buttonList.get(selectedButtonList).deselect();
				selectedButtonList--;
				buttonList.get(selectedButtonList).select();
			}
		} else if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
			buttonList.get(selectedButtonList).execute();
		}
	}
	
	void Draw(float dt) {
		SpriteBatch sb = playaround_game.batch;
		for (UIButton button : buttonList) button.draw(sb);
	}
	
	public void show() {}
	public void hide() {}
	public void dispose() {}
	public void pause() {}
	public void resize(int x, int y) {}
	public void resume() {}
}
