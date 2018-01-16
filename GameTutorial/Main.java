package com.luiscasas;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main extends JFrame{
	
	public Main() {
		initUI();
	}
	
	private void initUI() {
		
		// add(new Board());
		add(new Window());
		
		setSize(400, 300);
		setResizable(false);
		
		setTitle("Moving craft");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main ex = new Main();
				ex.setVisible(true);
			}
		});
		
	}

}
