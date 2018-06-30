package com.gx;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 * 贪吃蛇主窗体
 * @author 旭哥
 *
 */

public class SnakeGameFrame extends JFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	SnakeNode head = null;
	SnakeNode[] body = null;
	Food[] foods = new Food[6];
	private int snakeLength;
	PaintThread paintThread = null;
	
	public SnakeGameFrame() {
		this.setTitle("贪吃蛇 by 旭哥");
		this.setBounds(300, 300, 1024, 683);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void initialSnake() {
		int x1 = 180, y1 = 200;
		head = new SnakeNode(200, 200, 20, 20);
		body = new SnakeNode[50];
		snakeLength = 4;
		for(int i = 0;i < snakeLength;i++) {
			body[i] = new SnakeNode(x1, y1, 20, 20);
			x1-=20;
		}
		foods[1] = new Food();
		for(int i=0;i<6;i++) {
			foods[i] = new Food();
		}
		addKeyListener(new KeyMonitor());
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, 1024, 683, null);
		Color c = g.getColor();
		g.setColor(Color.RED);
		head.drawHead(g);
		
		g.setColor(Color.CYAN);
		for(int i = 0;i< snakeLength;i++) {
			body[i].drawBody(g);
			if(body[i].getRectangle().intersects(head.getRectangle())) {
				head.live = false;
			}
		}
		g.setColor(c);

		for(int i=0;i<6;i++) {
			if(foods[i].getRectangle().intersects(head.getRectangle())) {
				snakeLength ++;
				body[snakeLength - 1] = new SnakeNode(body[snakeLength - 2].x, body[snakeLength - 2].y, 20, 20);
				System.out.println("wow");
				foods[i].isEaten = true;
			}
			if(foods[i].isEaten == false)foods[i].draw(g);
		}
		
	}
	
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				
				if(head.live == false) {
					JOptionPane.showMessageDialog(null, "游戏结束，这都能死，下次小心点哦");
					break;
				}
				
				try {	
					for(int i = snakeLength - 1;i > 0;i--) {
						body[i].setLocation(body[i-1].x, body[i-1].y);
					}
					body[0].setLocation(head.x, head.y);
					if(head.x < 0 || head.x > 1004 || head.y < 0 || head.y > 663) {
						head.live = false;
					}
					repaint();
				
				Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			
			
			}
		}
	}
	
	class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			head.minusDirection(e);
			head.addDir(e);
			if(paintThread == null) {
				paintThread = new PaintThread();
				paintThread.start();
			}
		}

	}
	
	
	public static void main(String[] args) {
		SnakeGameFrame snakeGameFrame = new SnakeGameFrame();
		snakeGameFrame.initialSnake();
		
	}
}
