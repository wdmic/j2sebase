package com.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class TestPaint {

	public static void main(String[] args) {
		new PaintFrame();
	}

}

class PaintFrame extends Frame{
	public PaintFrame() {
		setBounds(200, 200, 640, 480);
		setVisible(true);
	}
	public void paint(Graphics graphics) {
		Color color = graphics.getColor();
		graphics.setColor(Color.RED);
		graphics.fillOval(50, 50, 30, 30);
		graphics.setColor(Color.green);
		graphics.fillRect(80, 80, 40, 40);
		graphics.setColor(color);
	}
}
