package com.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowClose {

	public static void main(String[] args) {
		new WindowFrame("233");
	}

}

class WindowFrame extends Frame{
	public WindowFrame(String string) {
		super(string);
		setLayout(null);
		setBounds(300, 300, 400, 300);
		setBackground(new Color(204, 204, 255));
		setVisible(true);
		//匿名类
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
	}
	/*内部类
	class MyWindowMonitor extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			setVisible(false);
			System.exit(0);
		}
	}
	*/
}
