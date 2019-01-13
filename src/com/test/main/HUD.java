package com.test.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class HUD {

	public static float HEALTH = 620;
	private float greenValue = 255;
	private int points = 0;
	private int level = 1;
	public int gameOver = 0;
	
	public void tick() 
	{
		HEALTH = (int) Game.clamp(HEALTH,  0, 630);
		greenValue = (int) Game.clamp(greenValue, 0, 255);
		
		greenValue = HEALTH / 3;
		if(!Player.enteredDoor)
			points++;

	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(20, 15, 1240, 32);
		g.setColor(new Color(75, (int)greenValue, 0));
		g.fillRect(20, 15, (int)HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(20, 15, 1240, 32);
		
		g.setFont(new Font("Comic Sans",Font.PLAIN, 16));
		g.drawString("Points: " + points, 20, 64);
		g.drawString("Level: " + level, 20, 80);
		
		if(HUD.HEALTH <= 0) 
		{
			g.setColor(Color.white);
			g.setFont(new Font("serif", Font.ITALIC, 120));
			g.drawString("GAME OVER", Game.WIDTH/3, Game.HEIGHT/3);
			gameOver = 1;
		}
	}
	public void setPoints(int points)
	{
		this.points = points;
	}
	public int getPoints()
	{
		return points;
	}
	public void setLevel(int level)
	{
		this.level = level;
	}
	public int getLevel()
	{
		return level;
	}
}
