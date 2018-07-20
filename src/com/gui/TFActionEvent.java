package com.gui;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFActionEvent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TFFrame();
	}

}

class TFFrame extends Frame{
	public TFFrame() {
		TextField tf = new TextField();
		tf.addActionListener(new TFActionListener());
		tf.setEchoChar('*');//ÉèÖÃ»ØÏÔ×Ö·û
		add(tf);
		pack();
		setVisible(true);
	}
}

class TFActionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
	
}