package disney;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

    // Create the "cards".
    JPanel card1 = new JPanel();
    card1.add(new JButton("Button 1"));
    cards.add(card1, BUTTONPANEL);

    JPanel card2 = new JPanel();
    card2.add(new JTextField("TextField", 20));
    cards.add(card2, TEXTPANEL);

    // Add the cards to the frame
    frame.add(cards, BorderLayout.CENTER);

    // Create a control panel
    JPanel controlPanel = new JPanel();
    controlPanel.setLayout(new FlowLayout());
    JButton nextButton = new JButton("Next");
    nextButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.next(cards);
      }
    });
    controlPanel.add(nextButton);
    frame.add(controlPanel, BorderLayout.SOUTH);

    // frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MultiPageApp();
      }
    });
  }
}
