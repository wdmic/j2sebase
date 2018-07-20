package com.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestAnonymous2 {
	
	Frame frame = new Frame();
	Button button = new Button();
	TextField textField = new TextField();
	public TestAnonymous2() {
		frame.add(button, BorderLayout.NORTH);
		frame.add(textField, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			private int i;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(e.getActionCommand() + ++i);
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				System.exit(0);
			}
		});
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new TestAnonymous2();
	}

}
