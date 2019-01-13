package com.test.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bow extends GameObject
{
	private SpriteSheet ss;
	public static boolean EQUIPPED = false;
	private boolean firing = false;
	
	public Bow(float x, float y, ID id, SpriteSheet ss) {
		super(x, y, id);
		this.ss = ss;
	}

	public void tick() 
	{
		
	}

	public void render(Graphics g) 
	{
		if(!EQUIPPED)
			g.drawImage(ss.crop(0, 0, 16, 16), (int)x, (int)y, 16 * 2,16 * 2, null);
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
	}
	
	public boolean getFiring()
	{
		return firing;
	}
	public void setFiring(boolean firing)
	{
		this.firing = firing;
	}
}
