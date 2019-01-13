package com.test.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
Random r = new Random();
private Handler handler;
private HUD hud;
public static boolean enteredDoor = false;
public static boolean enteredDoor2 = false;
private SpriteSheet ss;
public static int i = 1;

	public Player(int x, int y, ID id, Handler handler,HUD hud, SpriteSheet ss)
	{
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
		this.ss = ss;
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	public void tick() 
	{
		x += velX;
		y += velY;
		x = Game.clamp(x, 0, Game.WIDTH*2 - 22); 
		y = Game.clamp(y, 0, Game.HEIGHT - 45);
		
		collision();
		if(com.test.main.KeyInput.SHOOTING[0] && i == 1)
		{
			handler.addObject(new UpArrow(x, y, ID.Arrow, ss));
			i++;
		}
		if(com.test.main.KeyInput.SHOOTING[1] && i == 1)
		{
			handler.addObject(new DownArrow(x, y, ID.Arrow, ss));
			i++;
		}
		if(com.test.main.KeyInput.SHOOTING[2] && i == 1)
		{
			handler.addObject(new LeftArrow(x, y, ID.Arrow, ss));
			i++;
		}
		if(com.test.main.KeyInput.SHOOTING[3] && i == 1)
		{
			handler.addObject(new RightArrow(x, y, ID.Arrow, ss));
			i++;
		}
	}
	private void collision()
	{
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.BossMEnemy|| tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.FastEnemy)
			{
				//collision code
				if(getBounds().intersects(tempObject.getBounds()))
				{
					HUD.HEALTH -= 20;
				}
			}
		}
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Spikes || tempObject.getId() == ID.BossEnemy1)
			{
				//collision code
				if(getBounds().intersects(tempObject.getBounds()))
				{
					HUD.HEALTH -= 2000;
				}
			}
		}
		//for the door
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Door)
			{
				//collision code
				if(getBounds().intersects(tempObject.getBounds()))
				{
					enteredDoor = true;
					handler.removeObject(tempObject);
				}
			}
		}
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Door2)
			{
				//collision code
				if(getBounds().intersects(tempObject.getBounds()))
				{
					enteredDoor = false;
					enteredDoor2 = true;
				}
			}
		}
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Bow)
			{
				//collision code
				if(getBounds().intersects(tempObject.getBounds()))
				{
					Bow.EQUIPPED = true;
					
					hud.setPoints(hud.getPoints() - 3500);
					handler.removeObject(tempObject);
					handler.addObject(new Door(Game.WIDTH, 0, ID.Door2));
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 16, 16);
		if(BossEnemy1.BOSSDEFEATED)
		{
			g.setFont(new Font("serif", Font.ITALIC, 60));
			g.drawString("Congratualtions! You Won!", Game.WIDTH/4, Game.HEIGHT/2);
			for(int i = 0; i < handler.object.size(); i++)
			{
				GameObject tempObject = handler.object.get(i);
				
				if(tempObject.getId() == ID.SmartEnemy)
				{
					handler.removeObject(tempObject);
				}
			}
		}
		if(hud.getLevel() >= 15)
			g.drawImage(ss.crop(2, 1, 16, 16), (int)Game.WIDTH - 80, (int)Game.HEIGHT/4, 16 * 4,16 * 4, null);	
		if(Bow.EQUIPPED)
		{
			g.drawImage(ss.crop(3, 0, 16, 16), (int)Game.WIDTH + 16, (int)Game.HEIGHT/4, 16 * 4,16 * 4, null);
			g.setColor(Color.black);
			g.fillRect((int)Game.WIDTH - 80, (int)Game.HEIGHT/4, 16 * 4,16 * 4);
		}
	}
	public void shoot(int direction)
	{
		
	}
}
