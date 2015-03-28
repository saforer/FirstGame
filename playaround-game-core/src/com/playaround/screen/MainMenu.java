package com.playaround.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.playaround.game.playaround_game;
import com.playaround.menu.UIButton;
import com.playaround.menu.UIGameButton;
import com.playaround.menu.UIOptionsButton;

public class MainMenu implements Screen {
	List<UIButton> buttonList = new ArrayList<UIButton>();
	int selectedButtonList = 0;
	SpriteBatch sb;
	
	public MainMenu() {
		buttonList.add(new UIGameButton(buttonList.size(), true));
		buttonList.add(new UIOptionsButton(buttonList.size(), false));
	}
	
	public void show() {}
	
	public void render(float dt){
		Update(dt);
		Draw(dt);
	}
	
	public void Draw(float dt) {
		SpriteBatch sb = playaround_game.batch;
		for (UIButton button : buttonList) button.draw(sb);
	}

	public void Update(float dt) {
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
	
	public void dispose(){}	
	public void pause(){}
	public void hide(){}
	public void resume(){}
	public void resize(int x, int y){}
}
