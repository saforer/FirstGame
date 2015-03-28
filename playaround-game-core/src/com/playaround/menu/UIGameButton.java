package com.playaround.menu;

import com.playaround.screen.GameScreen;
import com.playaround.screen.ScreenManager;

public class UIGameButton extends UIButton {
	public UIGameButton(int inNumInMenuOptions, boolean selected) {
		super("Game Menu", inNumInMenuOptions, selected);
	}
	
	public void execute() {
		ScreenManager.getInstance().swapToScreen(new GameScreen());
	}
}
