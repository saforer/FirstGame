package com.playaround.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpaceObject {
	public boolean dead = false;
	float radians = 0;
	public Sprite sprite;
	float velX;
	float velY;
	
	public void Update(float dt) {
		sprite.setY(sprite.getY() + velY);
		sprite.setX(sprite.getX() + velX);
		Wrap();
	}
	
	void Wrap() {
		if (sprite.getY() > Gdx.graphics.getHeight()) {
			sprite.setY(0);
		}
		if (sprite.getY() < 0) {
			sprite.setY(Gdx.graphics.getHeight());
		}
		if (sprite.getX() > Gdx.graphics.getWidth()) {
			sprite.setX(0);
		}
		if (sprite.getX() < 0) {
			sprite.setX(Gdx.graphics.getWidth());
		}
	}
	
	public void draw(SpriteBatch sb) {
		if (!dead) {
			sprite.draw(sb);
		}
	}
}
