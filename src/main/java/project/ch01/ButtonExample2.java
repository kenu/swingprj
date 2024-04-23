package project.ch01;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonExample2 {
	ButtonExample2() {
		JFrame f = new JFrame("Button Example");
		URL resource = getClass().getResource("/images/dog.jpg");
		JButton b = new JButton(new ImageIcon(resource));
		b.setBounds(100, 100, 100, 60);
		f.add(b);
		f.setSize(300, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ButtonExample2();
	}
}