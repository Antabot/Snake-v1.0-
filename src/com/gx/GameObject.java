package com.gx;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * 游戏物体类
 * @author HASEE
 *
 */
public class GameObject {
	
	private int width;
	private int height;
	int x;
	int y;
	private Image img;
	
	public GameObject(Image img, int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.img = img;
	}
	
	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public GameObject() {

	}
	
	public void drawSelf(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}
	



}
