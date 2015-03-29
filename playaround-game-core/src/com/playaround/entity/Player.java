package com.playaround.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.playaround.game.playaround_game;
import com.playaround.screen.GameScreen;

public class Player extends SpaceObject{
	public Player() {
		sprite = new Sprite(new Texture("smallfreighterspr.png"));
		sprite.setCenter(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setY(Gdx.graphics.getHeight() / 2 - (sprite.getHeight() / 2));
		sprite.setX(Gdx.graphics.getWidth() / 2 - (sprite.getWidth() / 2));
		
	}
	
	public void Update(float dt) {
		if (!dead) {

			float rotationSpeed = 5;
			float speedMax = 10;
			float speed = 20;
			float brakes = 10;
			if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
				velY += MathUtils.cos(radians) * speed * dt;
				velX -= MathUtils.sin(radians) * speed * dt;
			}
			float vec = (float) Math.sqrt(velX * velX + velY * velY);
			if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				if (vec > 0) {
					velX -= (velX / vec) * brakes * dt;
					velY -= (velY / vec) * brakes * dt;
				}
			}
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {radians += rotationSpeed * dt;}
			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {radians -= rotationSpeed * dt;}
			
			if (!playaround_game.autofire) {
				if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
					Fire();
				}
			}
			
			if (playaround_game.autofire) {
				if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
					Fire();
				}			
			}
			
			if (vec > speedMax) {
				velX = (velX / vec) * speedMax;
				velY = (velY / vec) * speedMax;
			}		
			sprite.setY(sprite.getY() + velY);
			sprite.setX(sprite.getX() + velX);
			sprite.setRotation(MathUtils.radiansToDegrees * radians);
			Wrap();
		}
	}
	
	void Fire() {
		//Spawn Bullet
		GameScreen.bulletList.add(new Bullet(getXFront(), getYFront(), velX, velY, radians));
		//Slow down
		velX *= .75f;
		velY *= .75f;
	}
	
	float getXFront() {
		return sprite.getX() + sprite.getWidth() / 2;
	}
	
	float getYFront() {
		return sprite.getY() + sprite.getHeight() / 2;
	}
	
	public float shipWidth() {
		return sprite.getWidth()/2;
	}
}