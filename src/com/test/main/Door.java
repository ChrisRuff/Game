package com.test.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Door extends GameObject
{

	public Door(float x, float y, ID id) {
		super(x, y, id);

	}


	public void tick()
	{
			
	}

	public void render(Graphics g) {

		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, Game.HEIGHT);
	}

}
