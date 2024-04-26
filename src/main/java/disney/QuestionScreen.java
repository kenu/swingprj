package disney;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class QuestionScreen {
	QuestionScreen(int index) {
		JFrame f = new JFrame("Question");
		JButton b = new JButton("open result");
		JButton b2 = new JButton("open result");
		b.setBounds(50, 50, 200, 100);
		b2.setBounds(50, 150, 200, 100);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResultScreen(0);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResultScreen(1);
			}
		});
		f.add(b);
		f.add(b2);
		f.setSize(300, 400);
		f.setLayout(null);
		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new QuestionScreen(0);
	}
}
