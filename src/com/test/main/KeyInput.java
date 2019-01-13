package com.test.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	public static boolean[] SHOOTING = new boolean[4];

	
	public KeyInput(Handler handler) 
	{
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
		SHOOTING[0] = false;
		SHOOTING[1] = false;
		SHOOTING[2] = false;
		SHOOTING[3] = false;
	}
	
	public void keyPressed(KeyEvent e)
	{
	int key = e.getKeyCode();
	
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId()== ID.Player)
			{
				//key events for player 1
				if(key == KeyEvent.VK_W) 
				{
					tempObject.setVelY(-5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_S) 
				{
					tempObject.setVelY(5);
					keyDown[1] = true;
				}
				if(key == KeyEvent.VK_A) 
				{
					tempObject.setVelX(-5);
					keyDown[2] = true;
				}
				if(key == KeyEvent.VK_D) 
				{
					tempObject.setVelX(5);
					keyDown[3] = true;
				}
				if(key == KeyEvent.VK_UP && Bow.EQUIPPED)
				{
					SHOOTING[0] = true;
					
				}
				if(key == KeyEvent.VK_DOWN && Bow.EQUIPPED)
				{
					SHOOTING[1] = true;
					
				}
				if(key == KeyEvent.VK_LEFT && Bow.EQUIPPED)
				{
					SHOOTING[2] = true;
					
				}
				if(key == KeyEvent.VK_RIGHT && Bow.EQUIPPED)
				{
					SHOOTING[3] = true;
					
				}
			}
		
			if(key == KeyEvent.VK_ESCAPE) 
				System.exit(0);
		}
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++)
		{
			GameObject tempObject = handler.object.get(i);
			if(key == KeyEvent.VK_W && tempObject.getId()== ID.Player) 
			{
				//tempObject.setVelY(0);
				keyDown[0] = false;
			}
			if(key == KeyEvent.VK_S && tempObject.getId()== ID.Player) 
			{
				//tempObject.setVelY(0);
				keyDown[1] = false;
			}
			if(key == KeyEvent.VK_A && tempObject.getId()== ID.Player) 
			{
				//tempObject.setVelX(0);
				keyDown[2] = false;
			}
			if(key == KeyEvent.VK_D && tempObject.getId()== ID.Player) 
			{
				//tempObject.setVelX(0);
				keyDown[3] = false;
			}
			//vertical movement
			if(!keyDown[0] && !keyDown[1] && tempObject.getId()== ID.Player)
				tempObject.setVelY(0);
			//horizontal movement
			if(!keyDown[2] && !keyDown[3] && tempObject.getId()== ID.Player)
				tempObject.setVelX(0);
			
			if(key == KeyEvent.VK_UP)
			{
				SHOOTING[0] = false;
				Player.i = 1;
				
			}
			if(key == KeyEvent.VK_DOWN)
			{
				SHOOTING[1] = false;
				Player.i = 1;
				
			}
			if(key == KeyEvent.VK_LEFT)
			{
				SHOOTING[2] = false;
				Player.i = 1;
				
			}
			if(key == KeyEvent.VK_RIGHT)
			{
				SHOOTING[3] = false;
				Player.i = 1;
				
			}
		}
	}
}
