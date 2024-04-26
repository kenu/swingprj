package disney;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MultiPageApp {

	private JFrame frame;
	private JPanel cards; // a panel that uses CardLayout
	private final static String BUTTONPANEL = "Card with JButton";
	private final static String TEXTPANEL = "Card with JTextField";

	public MultiPageApp() {
		frame = new JFrame("Disney MBTI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 400);

		// Create a panel that uses CardLayout
		cards = new JPanel(new CardLayout());

		setQuestions();
						
		// Add the cards to the frame
		frame.add(cards, BorderLayout.CENTER);

		// Create a control panel
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cards.getLayout());
				if (Score.currentStep < 5) {
					cl.next(cards);				
				} else {
					showResult(cl);
				}
			}

		});
		controlPanel.add(nextButton);
		frame.add(controlPanel, BorderLayout.SOUTH);

		// frame.pack();
		frame.setVisible(true);
	}

	private void setQuestions() {
		// Create the "cards".
		JPanel card1 = new JPanel();
		card1.add(Scene.getPanel(1, "Text Field 1", "Button 1", "Button 2"));
		cards.add(card1, BUTTONPANEL);
		
		JPanel card2 = new JPanel();
		card2.add(Scene.getPanel(2, "Text Field 2", "Button 3", "Button 4"));
		cards.add(card2, BUTTONPANEL);

		JPanel card3 = new JPanel();
		card3.add(Scene.getPanel(3, "Text Field 3", "Button 5", "Button 6"));
		cards.add(card3, BUTTONPANEL);

		JPanel card4 = new JPanel();
		card4.add(Scene.getPanel(4, "Text Field 4", "Button 7", "Button 8"));
		cards.add(card4, BUTTONPANEL);

		JPanel card5 = new JPanel();
		card5.add(Scene.getPanel(5, "Text Field 5", "Button 9", "Button 10"));
		cards.add(card5, BUTTONPANEL);
	}

	Class<? extends MultiPageApp> class1 = getClass();
	private void showResult(CardLayout cl) {
		JPanel cardResult = new JPanel();
		cardResult.add(Scene.showResult(class1));
		cards.add(cardResult, TEXTPANEL);
		cl.next(cards);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MultiPageApp();
			}
		});
	}
}
