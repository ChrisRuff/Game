package com.test.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Spikes extends GameObject {

	private Handler handler;
	private HUD hud;

	public Spikes(int x, int y, ID id, Handler handler, HUD hud) {
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() 
	{
		if(hud.getLevel() >= 15)
		{
			handler.removeObject(this);
			
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.gray);
		for(int i = -1; i < 65; i++)
			g.fillPolygon(new int[] {Game.WIDTH,Game.WIDTH - 16, Game.WIDTH}, new int[] {0 + 16*i, 16 + 16 * i, 32 + 16 * i}, 3);
		if(hud.getLevel() >= 15)
		{
			g.setColor(Color.black);
			g.fillRect(Game.WIDTH - 32, 0, 32, Game.HEIGHT);
		}

	}

	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, 16, Game.HEIGHT);
	}

}
