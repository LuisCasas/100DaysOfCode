package com.luiscasas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;

public class Window extends JPanel implements ActionListener{
	
	private final int ICRAFT_X = 40;
	private final int ICRAFT_Y = 60;
	private final int DELAY = 10;
	private Timer timer;
	private Craft craft;
	
	public Window() {
		
		initWindow();
	}
	
	public void initWindow() {
		
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
		
		craft = new Craft(ICRAFT_X, ICRAFT_Y);
		
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		doDrawing(g);
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);
		
		ArrayList<Missile> ms = craft.getMissiles();
		
		for (Object m1 : ms) {
			Missile m = (Missile) m1;
			g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	    updateCraft();
	    updateMissiles();
	    
	    repaint();  
	}
	
	private void updateMissiles() {
		
		ArrayList<Missile> ms = craft.getMissiles();
		
		for(int i = 0; i < ms.size(); i++) {
			Missile m = (Missile) ms.get(i);
			
			if(m.isVisible()) {
				m.move();
			} else {
				ms.remove(i);
			}
		}
		
	}
	
	private void updateCraft() {
		craft.move();
	}
	
	private class TAdapter extends KeyAdapter{
		
		@Override
		public void keyReleased(KeyEvent e) {
			craft.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			craft.keyPressed(e);
		}
	}
}