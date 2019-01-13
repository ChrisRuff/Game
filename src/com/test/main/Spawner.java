package com.test.main;

import java.util.Random;

public class Spawner {
	private Handler handler;
	private HUD hud = new HUD();
	private int scoreKeep = 0;
	private Random r = new Random();
	private static int i = 1;

	
	public Spawner(Handler handler, HUD hud)
	{
		this.handler = handler;
		this.hud = hud;
	}
	
	public void tick() 
	{
		if(!Player.enteredDoor)
		{
			scoreKeep++;
		
			if(scoreKeep >= 250)
			{
				scoreKeep = 0;
				hud.setLevel(hud.getLevel() + 1);
			}
			if(hud.getLevel() < 10) 
			{
				if(hud.getLevel() >= 1 && hud.getLevel() <= 6 && System.currentTimeMillis() % 10 == 0)
				{
					handler.addObject(new BasicEnemy(0, r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				}
				if(hud.getLevel() >= 2 && hud.getLevel() <= 6 && System.currentTimeMillis() % 9 == 0)
				{
					handler.addObject(new BasicEnemy(0, r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				}
				if(hud.getLevel() >= 3 && hud.getLevel() <= 6 && System.currentTimeMillis() % 8 == 0)
				{
					handler.addObject(new BasicEnemy(0, r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				}
				if(hud.getLevel() >= 4 && hud.getLevel() <= 6 && System.currentTimeMillis() % 7 == 0)
				{
					handler.addObject(new BasicEnemy(0, r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				}
				if(hud.getLevel() >= 5 && hud.getLevel() <= 6 && System.currentTimeMillis() % 6 == 0)
				{
					handler.addObject(new FastEnemy(0, r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				}
				if(hud.getLevel() >= 6 && hud.getLevel() <= 6 && System.currentTimeMillis() % 6 == 0)
				{
					handler.addObject(new FastEnemy(0, r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				}
				if(hud.getLevel() == 7 && i == 1)
				{
					handler.addObject(new SmartEnemy(Game.WIDTH/2 - 8, Game.HEIGHT/2 - 8, ID.SmartEnemy, handler));
					i++;
				}
			}
			if(hud.getLevel() == 10 && i == 2)
			{
				handler.addObject(new BossEnemy1(Game.WIDTH/2 - 54, Game.HEIGHT/4, ID.BossEnemy1, handler, hud));
				i++;
			}
			if(Player.enteredDoor2 && i == 3)
			{
				handler.addObject(new SmartEnemy(Game.WIDTH/4 - 8, Game.HEIGHT/4 - 8, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(Game.WIDTH/4 * 2 - 8, Game.HEIGHT/4 - 8, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(Game.WIDTH/4 * 3 - 8, Game.HEIGHT/4 - 8, ID.SmartEnemy, handler));
				handler.addObject(new SmartEnemy(Game.WIDTH/4 * 4 - 8, Game.HEIGHT/4 - 8, ID.SmartEnemy, handler));
				i++;
			}
		}
			
		
	}
	public static int getI()
	{
		return i;
	}
}
