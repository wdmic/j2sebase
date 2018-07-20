package com.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent {

	public static void main(String[] args) {
		Frame frame = new Frame("Test");
		Button b1 = new Button("start");
		Button b2 = new Button("stop");
		Monitor monitor = new Monitor();
		b1.addActionListener(monitor);
		b2.addActionListener(monitor);
		b2.setActionCommand("over");
		frame.add(b1, BorderLayout.NORTH);
		frame.add(b2, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

}

class Monitor implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("a button has been pressed" + "info:" + e.getActionCommand());
	}
	
}
