package com.luiscasas;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Craft {
	
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    
    public Craft() {
    	
    		initCraft();
    }

    public void initCraft() {
    		
    		ImageIcon ii = new ImageIcon("images/craft.png");
    		image = ii.getImage();
    		x = 40;
    		y = 60;
    		
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

    public Image getImage() {
        return image;
    }   
    
    public void keyPressed(KeyEvent e) {
    		int key = e.getKeyCode();
    		
    		switch(key) {
    			case KeyEvent.VK_LEFT:
    				dx = -2;
    				break;
    			case KeyEvent.VK_RIGHT:
    				dx = 2;
    				break;
    			case KeyEvent.VK_UP:
    				dy = -2;
    				break;
    			case KeyEvent.VK_DOWN:
    				dy = 2;
    				break;
    		}
    }
 
    public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch(key) {
			case KeyEvent.VK_LEFT:
				dx = 0;
				break;
			case KeyEvent.VK_RIGHT:
				dx = 0;
				break;
			case KeyEvent.VK_UP:
				dy = 0;
				break;
			case KeyEvent.VK_DOWN:
				dy = 0;
				break;
		}
    }
    
    
}
