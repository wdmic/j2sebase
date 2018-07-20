package com.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;


public class MyMouseAdapter {

	public static void main(String[] args) {
		new MousePaintFrame("233");
	}

}

class MousePaintFrame extends Frame{
	
	ArrayList<Point> points = null;
	public MousePaintFrame(String string) {
		super(string);
		points = new ArrayList<Point>();
		setLayout(null);
		setBounds(300, 300, 400, 300);
		setVisible(true);
		addMouseListener(new MMonitor());
	}
	
	public void paint(Graphics graphics) {
		Iterator<Point> iterator = points.iterator();
		while (iterator.hasNext()) {
			Point point = iterator.next();
			graphics.setColor(Color.blue);
			graphics.fillOval(point.x, point.y, 10, 10);
		}
	}
	
	public void addPoint(Point point) {
		points.add(point);
	}
}

class MMonitor extends MouseAdapter{
	public void mousePressed(MouseEvent e) {
		MousePaintFrame frame = (MousePaintFrame) e.getSource();
		frame.addPoint(new Point(e.getX(), e.getY()));
		frame.repaint();
	}
}