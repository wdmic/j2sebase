package com.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

public class CenterPanel {

	public static void main(String[] args) {
		new MyFrame("233", 300, 300, 400, 300);
	}

}

class MyFrame extends Frame{
	private Panel panel;
	public MyFrame(String title, int x, int y, int w, int h) {
		super(title);
		setLayout(null);
		panel = new Panel(null);
		panel.setBounds(w/4, h/4, w/2, h/2);
		panel.setBackground(Color.YELLOW);
		add(panel);
		setBackground(Color.BLUE);
		setBounds(x, y, w, h);
		setVisible(true);
	}
}
