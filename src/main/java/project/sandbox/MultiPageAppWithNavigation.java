package project.sandbox;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class MultiPageAppWithNavigation {
  private JFrame frame;
  private JPanel cards; // a panel that uses CardLayout
  private final static String PAGE1 = "Page 1";
  private final static String PAGE2 = "Page 2";

  public MultiPageAppWithNavigation() {
    frame = new JFrame("Multi Page Swing Application with Navigation");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a panel that uses CardLayout
    cards = new JPanel(new CardLayout());

    // Create the "cards".
    JPanel card1 = new PageOne().extracted();
    cards.add(card1, PAGE1);

    JPanel card2 = new JPanel();
    card2.add(new JLabel("This is Page 2"));
    cards.add(card2, PAGE2);

    // Add the cards to the frame
    frame.add(cards, BorderLayout.CENTER);

    // Create a navigation side
    JPanel navigationPanel = new JPanel();
    navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.Y_AXIS));
    JList<String> navigationList = new JList<>(new String[] {PAGE1, PAGE2});
    navigationList.addListSelectionListener(e -> {
      CardLayout cl = (CardLayout) (cards.getLayout());
      cl.show(cards, navigationList.getSelectedValue());
    });
    navigationPanel.add(new JScrollPane(navigationList));
    frame.add(navigationPanel, BorderLayout.WEST);

    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MultiPageAppWithNavigation();
      }
    });
  }
}
