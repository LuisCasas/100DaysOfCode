package com.luiscasas;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Craft extends Sprite{
	
    private int dx;
    private int dy;
    private ArrayList<Missile> missiles;
    
    public Craft(int x, int y) {
    		super(x, y);
    		
    		initCraft();
    }

    public void initCraft() {
    		
    		missiles = new ArrayList<>();
    		loadImage("images/craft.png");
    		getImageDimensions();
    		
    }
    
    public void move() {
    		x += dx;
    		y += dy;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public ArrayList<Missile> getMissiles() {
    		return missiles;
    }
    
    public void keyPressed(KeyEvent e) {
    		int key = e.getKeyCode();
    		
    		if(key == KeyEvent.VK_SPACE) {
    			fire();
    		}
    		
    		if(key == KeyEvent.VK_LEFT) {
    			dx = -2;
    		}   		
    		
    		if(key == KeyEvent.VK_RIGHT) {
    			dx = 2;
    		} 
    		
    		if(key == KeyEvent.VK_UP) {
    			dy = -2;
    		} 
    		
    		if(key == KeyEvent.VK_DOWN) {
    			dy = 2;
    		} 
    }
    
    public void fire() {
    		missiles.add(new Missile(x + width, y + height / 2));
    }
 
    public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dx = 0;
		}   		
		
		if(key == KeyEvent.VK_RIGHT) {
			dx = 0;
		} 
		
		if(key == KeyEvent.VK_UP) {
			dy = 0;
		} 
		
		if(key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
    }
    
    
}
