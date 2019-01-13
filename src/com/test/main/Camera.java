package com.test.main;

public class Camera 
{
	private float x, y;
	
	public Camera(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void tick()
	{
		if(x > -Game.WIDTH && Player.enteredDoor)
		{
			x = x - 15;
		}
		if(x < 0 && Player.enteredDoor2)
		{
			x = x + 15;
		}
	}
	
	public float getX()
	{
		return x;
	}
	public float getY()
	{
		return y;
	}
	public void setX(float x)
	{
		this.x = x;
	}
	public void setY(float y)
	{
		this.y = y;
	}
}
