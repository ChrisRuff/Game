package com.test.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class DownArrow extends GameObject
{
	private SpriteSheet ss;

	public DownArrow(float x, float y, ID id, SpriteSheet ss)
	{
		super(x, y, id);
		this.ss = ss;

		velY = 4;
	}


	public void tick() 
	{

		x += velX;
		y += velY;
			
	}


	public void render(Graphics g)
	{
		g.drawImage(ss.crop(2, 0, 16, 16), (int)x, (int)y, 16 * 2,16 * 2, null);
	}


	public Rectangle getBounds() 
	{
		return new Rectangle((int)x, (int)y, 4, 8);
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