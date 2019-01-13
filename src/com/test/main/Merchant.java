package com.test.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Merchant extends GameObject{

	public Merchant(float x, float y, ID id, Handler handler, HUD hud) 
	{
		super(x, y, id);

	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	public void tick() 
	{
	
		//handler.addObject(new BasicTrail(x,y,ID.BasicTrail,Color.green, 8, 8, 0.01, handler));
	}

	public void render(Graphics g) 
	{
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, 32, 32);
		if(Player.enteredDoor)
		{
			g.setFont(new Font("comic sans", Font.BOLD, 30));
			g.setColor(Color.white);
			g.drawString("Welcome to my store!", Game.WIDTH + Game.WIDTH /2, Game.HEIGHT / 4);
			//g.drawString("", x, y);
			if(Bow.EQUIPPED)
			{
				g.setFont(new Font("serif", Font.ITALIC, 20));
				g.drawString("Use the Arrow keys to fire the bow!", Game.WIDTH + Game.WIDTH /6, Game.HEIGHT / 3);
			}
		}
		
	}

	
}
