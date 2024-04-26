package disney;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ResultScreen {
	ResultScreen(int index) {
		JFrame f = new JFrame("Button Example");
		String[] characters = { "Mulan", "Elsa", "Cinderella", "Belle" };
		String character = characters[index];
		URL resource = getClass().getResource("/images/character/" + character + ".jpeg");
		JButton b = new JButton(new ImageIcon(resource));
		b.setBounds(50, 50, 200, 200);
		f.add(b);
		f.setSize(300, 400);
		f.setLayout(null);
		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ResultScreen(0);
		new ResultScreen(1);
		new ResultScreen(2);
		new ResultScreen(3);
	}
}
