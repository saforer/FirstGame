package com.playaround.menu;

import com.playaround.screen.OptionsScreen;
import com.playaround.screen.ScreenManager;

public class UIOptionsButton extends UIButton {
	public UIOptionsButton(int inNumOption, boolean selected) {
		super("Options Menu", inNumOption, selected);
	}
	
	public void execute() {
		ScreenManager.getInstance().swapToScreen(new OptionsScreen());
	}
}
