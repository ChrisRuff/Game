package com.test.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class BossEnemy1 extends GameObject{
	private Handler handler;
	private Random r = new Random();
	private int health = 500;
	public static boolean BOSSDEFEATED = false;
	private boolean hit = false; 
	private int z = 0;
	
	public BossEnemy1(float x, float y, ID id, Handler handler,HUD hud) 
	{
		super(x, y, id);
	this.handler = handler;
	velX = 5;
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 64, 64);
	}
	public void tick() 
	{
		if(x == Game.WIDTH - 64)
			velX = -5;
		
		if(x == 1)
			velX = 5;
		x += velX;
		
		if(System.currentTimeMillis() % 5 == 0)
		{
			handler.addObject(new BossMEnemy(x, y, ID.BossMEnemy, handler));
			handler.addObject(new BossMEnemy(r.nextInt(Game.WIDTH), 0, ID.BossMEnemy, handler));
		}
		
		Collision();
		//handler.addObject(new BasicTrail(x,y,ID.BasicTrail,Color.green, 8, 8, 0.01, handler));
	}

	public void Collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Arrow)
			{
				//collision code
				if(getBounds().intersects(tempObject.getBounds()))
				{
					health -= 20;
					hit = true;
					handler.removeObject(tempObject);
					if(health <= 0)
					{
						handler.removeObject(this);
						BOSSDEFEATED = true;
					}
				}
			}
		}
	}
	public void render(Graphics g) 
	{
		if(!hit)
		{
			g.setColor(Color.red);
		}
		if(hit)
		{
			g.setColor(Color.white);
			z++;
				if(z >= 20)
				{
					hit = false;
				}
		}
		g.fillRect((int)x, (int)y, 64, 64);
		
	}
}

