package com.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFMath {

	public static void main(String[] args) {
		new MyyFrame().launchFrame();
	}

}

class MyyFrame extends Frame{
	
	TextField tf1, tf2, tf3;
	public void launchFrame() {
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(15);
		Button button = new Button("=");
		Label label = new Label("+");
		setLayout(new FlowLayout());
		MyMonitor mm = new MyMonitor();
		button.addActionListener(mm);
		add(tf1);
		add(label);
		add(tf2);
		add(button);
		add(tf3);
		pack();
		setVisible(true);
	}
	//内部类，可以方便访问包装类的成员，可以不被其它类访问
	class MyMonitor implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			int n1 = Integer.parseInt(tf1.getText());
			int n2 = Integer.parseInt(tf2.getText());
			tf3.setText((n1 + n2) + "");
		}
		
	}
}
/*
class MyMonitor implements ActionListener{
	
	MyyFrame mf;
	
	public MyMonitor(MyyFrame mf) {
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int n1 = Integer.parseInt(mf.tf1.getText());
		int n2 = Integer.parseInt(mf.tf2.getText());
		mf.tf3.setText((n1 + n2) + "");
	}
	
}
*/