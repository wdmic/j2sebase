package com.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class TestLayout {

	public static void main(String[] args) {
		int flag = 4;
		if (flag == 1) {//FlowLayout
			Frame frame = new Frame("FlowLayout");
			FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 20, 40);
			frame.setLayout(fl);
			frame.setLocation(200, 300);
			frame.setSize(200, 300);
			for (int i = 0; i < 7; i++) {
				frame.add(new Button("button" + i));
			}
			frame.setVisible(true);
		}
		
		if (flag == 2) {//BorderLayout
			Frame frame = new Frame("BorderLayout");
			frame.setLocation(200, 300);
			frame.setSize(200, 300);
			frame.add(new Button("BN"), BorderLayout.NORTH);
			frame.add(new Button("BS"), BorderLayout.SOUTH);
			frame.add(new Button("BW"), BorderLayout.WEST);
			frame.add(new Button("BE"), BorderLayout.EAST);
			frame.add(new Button("BC"), BorderLayout.CENTER);
			frame.setVisible(true);
		}
		
		if (flag == 3) {//GridLayout
			Frame frame = new Frame("GridLayout");
			GridLayout gl = new GridLayout(3, 2);
			frame.setLayout(gl);
			for (int i = 0; i < 6; i++) {
				frame.add(new Button("b" + i));
			}
			frame.pack();
			frame.setLocation(200, 300);
			frame.setVisible(true);
		}
		
		if (flag == 4) {//вш╨о
			Frame frame = new Frame();
			Panel p0 = new Panel(new GridLayout(2, 1));
			Panel p1 = new Panel(new GridLayout(2, 1));
			Panel p2 = new Panel(new GridLayout(2, 1));
			Panel p3 = new Panel(new GridLayout(2, 2));
			Panel p4 = new Panel(new GridLayout(2, 1));
			p4.add(p2); p4.add(p3);
			for (int i = 0; i < 2; i++) {
				p0.add(new Button());
				p1.add(new Button());
				p2.add(new Button());
			}
			for (int i = 0; i < 4; i++) {
				p3.add(new Button());
			}
			frame.add(p0, BorderLayout.WEST);
			frame.add(p1, BorderLayout.EAST);
			frame.add(p4, BorderLayout.CENTER);
			frame.setLocation(200, 300);
			frame.setSize(200, 300);
			frame.setVisible(true);
		}
	}

}
