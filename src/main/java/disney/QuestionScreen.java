package disney;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class QuestionScreen {
	QuestionScreen(int index) {
		JFrame f = new JFrame("Question");

		String text = "Upper result";
		int y = 50;
		int resultValue = 0;
		JButton b = getButton(text, y, resultValue);
		f.add(b);

		String text2 = "Lower result";
		int resultValue2 = 1;
		int y2 = 150;
		JButton b2 = getButton(text2, y2, resultValue2);
		f.add(b2);
		f.setSize(300, 400);
		f.setLayout(null);
		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JButton getButton(String answer, int y, int resultValue) {
		JButton b = new JButton(answer);
		b.setBounds(50, y, 200, 100);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("click " + resultValue);
				new ResultScreen(resultValue);
			}
		});
		return b;
	}

	public static void main(String[] args) {
		new QuestionScreen(0);
	}
}
