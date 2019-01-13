package com.test.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class SmartEnemy extends GameObject{
	private Handler handler;
	private GameObject player;
	public static int test = 1;
	
	public SmartEnemy(int x, int y, ID id, Handler handler) 
	{
		super(x, y, id);
	this.handler = handler;
	
	for(int i = 0; i < handler.object.size(); i++)
		if(handler.object.get(i).getId() == ID.Player)
			player = handler.object.get(i);
			
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 8, 8);
	}
	public void tick() 
	{

		x += velX;
		y += velY;
		
		float diffX = x - player.getX() - 8;
		float diffY = y - player.getY() - 8;
		float distance = (float)Math.sqrt((x-player.getX())*(x-player.getX())+ (y-player.getY())*(y-player.getY()));
		
		velX = (float)((-1.0/distance) * diffX);
		velY = (float)((-1.0/distance) * diffY);
		
		if(x > Game.WIDTH)
			handler.removeObject(this);
		handler.addObject(new BasicTrail(x,y,ID.BasicTrail,Color.cyan, 8, 8, 0.02, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 8, 8);
		
	}
	
}
