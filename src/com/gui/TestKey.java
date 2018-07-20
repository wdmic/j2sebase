package com.gui;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKey {

	public static void main(String[] args) {
		new KeyFrame();
	}

}

class KeyFrame extends Frame{
	public KeyFrame() {
		setBounds(200, 200, 300, 300);
		setVisible(true);
		addKeyListener(new MyKeyMonitor());
	}
	
	class MyKeyMonitor extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int KeyCode = e.getKeyCode();
			if (KeyCode == KeyEvent.VK_UP) {
				System.out.println("UP");
			}
		}
	}
}
