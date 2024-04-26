package disney;

import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Scene {

	public static JPanel getPanel(String label, String text1, String text2) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.PAGE_AXIS));

		subPanel.add(new JLabel(label));
		subPanel.add(new JButton(text1));
		subPanel.add(new JButton(text2));
		return subPanel;
	}
	
	public static JPanel getResult(int index, Class<?> context) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.PAGE_AXIS));
		
		String[] characters = { "Mulan", "Elsa", "Cinderella", "Belle" };
		String character = characters[index];
		URL resource = context.getResource("/images/character/" + character + ".jpeg");
		JButton b = new JButton(new ImageIcon(resource));
		b.setBounds(50, 50, 200, 200);
		
		subPanel.add(b);

		return subPanel;		
	}

}
