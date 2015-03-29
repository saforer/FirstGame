package com.playaround.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.playaround.screen.ScreenManager;

public class playaround_game extends ApplicationAdapter {
	public static SpriteBatch batch;
	public static ScreenManager sm;
	public static String selectedBackground = "badlogic.jpg";
	public static List<String> backgroundList = new ArrayList<String>();
	public static boolean autofire = false;
	
	public void create () {
		batch = new SpriteBatch();
		sm = new ScreenManager();
		
		backgroundList.add("badlogic.jpg");
		backgroundList.add("MenuButtonOff.png");
		backgroundList.add("MenuButtonOn.png");
	}

	
	public void render () {			
		Gdx.gl.glClearColor(.5f, .5f, .5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sm.draw(Gdx.graphics.getDeltaTime());
		batch.end();
	}
}