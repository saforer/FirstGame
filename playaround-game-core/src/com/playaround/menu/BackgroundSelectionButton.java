package com.playaround.menu;

import com.playaround.game.playaround_game;
import com.playaround.screen.MainMenu;
import com.playaround.screen.ScreenManager;

public class BackgroundSelectionButton extends UIButton {
	public BackgroundSelectionButton(String inText, int inNumOption, boolean selected) {
		super(inText, inNumOption, selected);
	}
	
	public void execute() {
		playaround_game.selectedBackground = text;
		ScreenManager.getInstance().swapToScreen(new MainMenu());
	}
}
