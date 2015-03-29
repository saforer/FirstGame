package com.playaround.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

public class Bullet extends SpaceObject{
	public Bullet(float posX, float posY, float inVelX, float inVelY, float inRadians) {
		
		sprite = new Sprite(new Texture("BulletBill.png"));
		sprite.setX(posX - sprite.getWidth() / 2);
		sprite.setY(posY - sprite.getHeight() / 2);
		radians = inRadians;
		velX = inVelX;
		velY = inVelY;
		float minimumSpeed = 4;
		
		if ((velX + velY) < minimumSpeed) {
			velY += MathUtils.cos(radians) * minimumSpeed;
			velX -= MathUtils.sin(radians) * minimumSpeed;
		}
		sprite.setRotation(MathUtils.radiansToDegrees * (radians + (3 * MathUtils.PI) / 2));
	}
}
