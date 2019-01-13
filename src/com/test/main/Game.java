package com.test.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;



public class Game extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -2681032978929841738L;
	public static final int WIDTH = 1280, HEIGHT = WIDTH / 12 * 9;
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Spawner spawner;
	ImageLoader loader = new ImageLoader();
	public static boolean world;
	private Camera cam;
	private BufferedImage spriteSheet = loader.load("/SpriteSheet.png");
	private SpriteSheet ss = new SpriteSheet(spriteSheet);
	
	public Game() 
	{
		this.requestFocus();
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		new Window(WIDTH, HEIGHT, "Let's Go!", this);
		cam = new Camera(0,0);
		hud = new HUD();
		spawner = new Spawner(handler, hud);
		
		handler.addObject(new Player(WIDTH/2 - 32, HEIGHT/2 - 32, ID.Player, handler, hud, ss));
		handler.addObject(new Spikes(WIDTH-32, 0, ID.Spikes, handler, hud));
		handler.addObject(new Door(WIDTH- 32, 0, ID.Door));
		handler.addObject(new Merchant(WIDTH/2 * 3, HEIGHT/3, ID.Merchant, handler,hud));
		handler.addObject(new Bow(WIDTH/4 * 5, HEIGHT /2, ID.Bow, ss));
		

		
		
		world = true;
	}

	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void stop()
	{
		try {
			thread.join();
			running = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) 
			{
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	private void tick() 
	{
		handler.tick();
		hud.tick();
		spawner.tick();
		cam.tick();
		if(hud.gameOver == 1) 
		{
		 	sleep(5000);
			System.exit(0);
		}	
	}
	
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		
		
//		if(Player.enteredDoor)
//		{
//			g.setColor(new Color(100, 60, 60));
//			g.fillRect(0, 0, WIDTH, HEIGHT);
//		}
//		else if(!Player.enteredDoor)
//		{
//			g.setColor(Color.black);
//			g.fillRect(0, 0, WIDTH, HEIGHT);
//		}
		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g2d.translate(cam.getX(), cam.getY());
		
		handler.render(g);
		
		g2d.translate(-cam.getX(), -cam.getY());
		hud.render(g);
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var, float min, float max)
	{
		if(var >= max)
			return  var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}

	public static void sleep(int time)
	{
		try {
			Thread.sleep(time);
		} catch (Exception e) {}
	}
	public static void main(String args[]) throws InterruptedException 
	{
		new Game();
		
	}

}

