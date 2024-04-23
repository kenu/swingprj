package project.sandbox;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PageOne {
  public JPanel extracted() {
    JPanel card1 = new JPanel();
    card1.add(new JLabel("This is Page 1"));
    return card1;
  }
}
