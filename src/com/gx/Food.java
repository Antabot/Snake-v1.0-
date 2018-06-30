package com.gx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Food extends GameObject{
	public boolean isEaten = false;
	
	public Food() {
		x = (int)(Math.random() * 50)*20;
		y = (int)(Math.random() * 30)*20;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 20, 20);
		g.setColor(c);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x, y, 20, 20);
	}

	
}
