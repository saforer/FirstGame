package com.playaround.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class UIButton {
	Texture backgroundElement;
	BitmapFont font = new BitmapFont();
	String text;
	int numInMenuOptions;
	
	public UIButton(String inText, int inNumInMenuOptions, boolean selected) {
		text = inText;
		numInMenuOptions = inNumInMenuOptions;
		if (selected) {
			select();
		} else {
			deselect();
		}
	}
	
	public void select() {
		backgroundElement = new Texture("MenuButtonOn.png");
	}
	
	public void deselect() {
		backgroundElement = new Texture("MenuButtonOff.png");
	}
	
	public void draw(SpriteBatch sb) {
		int ypos = Gdx.graphics.getHeight() - (52) - (numInMenuOptions * 48);
		sb.draw(backgroundElement, 0, ypos);
		font.draw(sb, text, 20, 30 + ypos);
	}
	
	public void execute() {}
}