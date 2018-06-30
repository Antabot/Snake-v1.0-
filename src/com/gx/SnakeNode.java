package com.gx;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class SnakeNode extends GameObject {
	int x;
	int y;
	private int width;
	private int height;
	boolean left, up, right , down, live = true;
	int speed = 20;
	public SnakeNode(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public SnakeNode() {
		
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void addDir(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37:
			if(!right)
			left = true;
			break;
		case 38:
			if(!down)
			up = true;
			break;
		case 39:
			if(!left)
			right = true;
			break;
		case 40:
			if(!up)
			down = true;
			break;
		}
	}
	public void minusDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37:
			up = false;
			//right = false;
			down = false;
			break;
		case 38:
			left = false;
			right = false;
			//down = false;
			break;
		case 39:
			//left = false;
			up = false;
			down = false;
			break;
		case 40:
			left = false;
			//up = false;
			right = false;
			break;
		}
	}
	public void drawBody(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
	public void drawHead(Graphics g) {
		
		if (left) {
			x -= speed; 
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		if (down) {
			y += speed;
		}
		g.fillRect(x, y, width, height);
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x, y, 20, 20);
	}

	
}
