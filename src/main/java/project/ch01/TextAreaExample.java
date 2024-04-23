package project.ch01;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextAreaExample {
	TextAreaExample() {
		JFrame f = new JFrame();
		JTextArea area = new JTextArea("Welcome to javatpoint");
		area.setBounds(10, 30, 200, 200);
		f.add(area);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		new TextAreaExample();
	}
}