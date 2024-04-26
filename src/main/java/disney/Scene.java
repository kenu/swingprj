package disney;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Scene {

	public static JPanel getPanel(int step, String label, String text1, String text2) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.PAGE_AXIS));

		JButton button1 = new JButton(text1);
		JButton button2 = new JButton(text2);

        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                	Score.setScore(step, 1);
                    System.out.println("Button 1 was clicked +1: " + Score.getScore());
                } else if (e.getSource() == button2) {
                	Score.setScore(step, 0);
                    System.out.println("Button 2 was clicked +0: " + Score.getScore());
                }
            }
        };
        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        
		subPanel.add(new JLabel(label));
		subPanel.add(button1);
		subPanel.add(button2);
		
		return subPanel;
	}
	
	public static JPanel showResult(Class<?> context) {
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.PAGE_AXIS));
		
		String[] characters = { "Mulan", "Elsa", "Cinderella", "Belle" };
		int index = Score.getScore();
		if (index >= characters.length) {
			index = index % characters.length;
		}
		String character = characters[index];
		URL resource = context.getResource("/images/character/" + character + ".jpeg");
		JButton b = new JButton(new ImageIcon(resource));
		b.setBounds(50, 50, 200, 200);
		
		subPanel.add(b);
		
		Score.reset();

		return subPanel;		
	}

}
