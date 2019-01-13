package com.test.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class BasicEnemy extends GameObject{
	private Handler handler;
	public BasicEnemy(float x, float y, ID id, Handler handler) 
	{
		super(x, y, id);
	this.handler = handler;
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 8, 8);
	}
	public void tick() 
	{
		velX = 2;
		x+= velX;
		y+= velY;
		if(x > Game.WIDTH)
			handler.removeObject(this);
		//handler.addObject(new BasicTrail(x,y,ID.BasicTrail,Color.green, 8, 8, 0.01, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 8, 8);
		
	}

	
}
