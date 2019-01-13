package com.test.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class LeftArrow extends GameObject
{
	private SpriteSheet ss;


	public LeftArrow(float x, float y, ID id, SpriteSheet ss)
	{
		super(x, y, id);
		this.ss = ss;
		velX = -4;
	}


	public void tick() 
	{

		x += velX;
		y += velY;
			
	}


	public void render(Graphics g)
	{
		g.drawImage(ss.crop(1, 1, 16, 16), (int)x, (int)y, 16 * 2,16 * 2, null);
	}


	public Rectangle getBounds() 
	{
		return new Rectangle((int)x, (int)y, 8, 4);
	}

	public void setVelX(float velX)
	{
		this.velX = velX;
	}
	public void setVelY(float velY)
	{
		this.velY = velY;
	}
}