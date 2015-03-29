package com.playaround.menu;

import com.playaround.game.playaround_game;
import com.playaround.screen.MainMenu;
import com.playaround.screen.ScreenManager;

public class SetAutoFire extends UIButton {
	boolean autofire;
	public SetAutoFire(String inText, int inNumInOptions, boolean isSelected, boolean setFireHere) {
		super(inText, inNumInOptions, isSelected);
		autofire = setFireHere;
	}
	
	public void execute() {
		playaround_game.autofire = autofire;
		ScreenManager.instance.swapToScreen(new MainMenu());
	}
}
