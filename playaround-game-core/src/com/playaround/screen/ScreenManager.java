package com.playaround.screen;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Screen;

public class ScreenManager {
	public static ScreenManager instance;
	List<Screen> screenList;
	
	public ScreenManager() {
		instance = this;
		

		instance.screenList = new ArrayList<Screen>();
		instance.screenList.add(new MainMenu());
	}
		
	public static ScreenManager getInstance() {
		return instance;
	}
	
	public void addScreen(Screen screen) {
		screen.show();
		instance.screenList.add(screen);
	}
	
	public void emptyScreenList() {
		instance.screenList.clear();
	}
	
	public void swapToScreen(Screen screen) {
		instance.emptyScreenList();
		screen.show();
		instance.addScreen(screen);
	}
	
	public void draw(float dt) {
		for (int i = 0; i < screenList.size(); i++) {
			screenList.get(i).render(dt);
		}
	}
}