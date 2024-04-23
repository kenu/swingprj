package project;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Simple2 extends JFrame {// inheriting JFrame
  private static final long serialVersionUID = 1L;
  JFrame f;

  Simple2() {
    JButton b = new JButton("click");// create button
    b.setBounds(130, 100, 100, 40);

    add(b);// adding button on frame
    setSize(400, 500);
    setLayout(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Simple2();
  }
}
